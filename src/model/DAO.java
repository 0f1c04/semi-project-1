package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DAO {
    public void ParsingXML() throws ParserConfigurationException, IOException, SAXException {
        String url = "http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic?"; /*URL*/
        String ServiceKey = "E%2BZTrGwIlQduLFIYgx4BLluIr5uMHb%2FqqhckInIDSU9jG7cf549CZ3%2BXfANRqOTNmE3w4gNsA6rbA%2B4B8PIgWw%3D%3D";
        String queryParams = '&' + "ServiceKey" + '=' + ServiceKey; /*Service Key*/


        // 페이지 접근 Document 객체 생성
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url + queryParams);

        // root tag
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // 파싱할 tag
        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("파싱할 item 수: " + nList.getLength());

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("------------------------");
                System.out.println("유기번호: " + getTagValue("desertionNo", eElement));//
                System.out.println("이미지경로: " + getTagValue("popfile", eElement));//
                System.out.println("접수일: " + getTagValue("happenDt", eElement));//
                System.out.println("발견장소: " + getTagValue("happenPlace", eElement));//
                System.out.println("품종: " + getTagValue("kindCd", eElement));//
                System.out.println("색상: " + getTagValue("colorCd", eElement));//
                System.out.println("나이: " + getTagValue("age", eElement));
                System.out.println("체중: " + getTagValue("weight", eElement));//
                System.out.println("공고번호: " + getTagValue("noticeNo", eElement));
                System.out.println("공고시작일: " + getTagValue("noticeSdt", eElement));
                System.out.println("공고종료일: " + getTagValue("noticeEdt", eElement));
                System.out.println("상태: " + getTagValue("processState", eElement));//
                System.out.println("성별: " + getTagValue("sexCd", eElement));//

                System.out.println("중성화여부: " + getTagValue("neuterYn", eElement));//
                System.out.println("특징: " + getTagValue("specialMark", eElement));//
                System.out.println("보호소이름: " + getTagValue("careNm", eElement));
                System.out.println("보호소전화번호: " + getTagValue("careTel", eElement));
                System.out.println("보호장소: " + getTagValue("careAddr", eElement));
                System.out.println("관할기관: " + getTagValue("orgNm", eElement));
                System.out.println("담당자: " + getTagValue("chargeNm", eElement));
                System.out.println("담당자연락처: " + getTagValue("officetel", eElement));
                System.out.println("특이사항: " + getTagValue("specialMark", eElement));
            }
        }
    }

    // tag값의 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        Node nValue = null;

        if (eElement.getElementsByTagName(tag).getLength() > 0) {
            NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
            nValue = (Node) nlList.item(0);
        }
        if (nValue == null)
            return "정보없음";

        return nValue.getNodeValue();
    }
}
