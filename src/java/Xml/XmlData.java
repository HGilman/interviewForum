package Xml;

//package java.data;
//
//import java.entities.Person;
//import org.w3c.dom.*;
//import org.xml.sax.SAXException;
//
//import javax.naming.ConfigurationException;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//
///**
// * Created by Хасан on 16.11.2014.
// */
//public class XmlData {
//
//    public void load(String xmlFileName){
//
//        try {
//            Document doc = docInit(xmlFileName);
//
//            if (!doc.getDocumentElement().getNodeName().equals(Storage.Persons_ROOT)) {
//                System.err.println("root must be <Tables>");
//            }
//            NodeList fLevelNodes = doc.getChildNodes();
//            //System.err.println(fLevelNodes.item(0).getNodeName());
//            NodeList nList = fLevelNodes.item(0).getChildNodes();
//            for (int i = 0; i < nList.getLength(); i++) {
//                //System.err.println(nList.item(i).getNodeName());
//                if (nList.item(i).getNodeName().equals(Storage.Persons_ELEMENT)) {
//                    nList = nList.item(i).getChildNodes();
//                }
//            }
//            Storage.fillPersons(fillPersons(nList));
//
//            System.out.println("File is sucssesfuly loaded");
//        }catch (FileNotFoundException e){
//            System.out.println("File is not found");
//        }catch (NullPointerException e) {
////            e.printStackTrace();
//            System.out.println("File is not found , try once more" + "\n");
//        }
//    }
//
//    public void save(String fileName){
//        Document doc = null;
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder db = factory.newDocumentBuilder();
//            DOMImplementation domImplementation = db.getDOMImplementation();
//            doc = domImplementation.createDocument(null, "Tables", null);
//
//            buildTree(doc, doc.getDocumentElement());
//
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//
//            Properties transfProps = new Properties();
//            transfProps.put("method", "xml");
//            transfProps.put("indent", "yes");
//            transformer.setOutputProperties(transfProps);
//
//            DOMSource source = new DOMSource(doc);
//            OutputStream out = new FileOutputStream(new File(fileName));
//            StreamResult result =  new StreamResult(out);
//            //StreamResult result =  new StreamResult(System.out);
//            transformer.transform(source, result);
//            try {
//                out.close();
//            } catch (Exception ex) {}
//        } catch (Exception ex) {
//            System.err.println("XML error\n"+ex.toString());
//        }
//    }
//
//
//    private Element createXmlObj(Document doc, String root, String[] args, String ... values){
//        Element e = createElement(doc, root, null);
//        for(int i = 0; i < args.length; i++){
//            e.appendChild(createElement(doc, args[i], values[i]));
//        }
//        return e;
//    }
//
//    private Element createElement(Document doc, String name, String textContent) {
//        Element elem = doc.createElement(name);
//        if(textContent!=null)
//            elem.setTextContent(textContent);
//        return elem;
//    }
//
//    private void buildTree(Document doc, Element root) {
//        // setting up document
//        doc.setXmlStandalone(true);
//        doc.setStrictErrorChecking(true);
//        doc.setXmlVersion("1.0");
//
//        Element subRoot = createElement(doc, "persons", null);
//        Element e;
//
//        for(Map.Entry<Integer, Person> i:  Storage.getPersons()){
//            String[] args = {"person_id", "first_name", "last_name",
//                    "login", "password", "email", "rating", "age", "status","companies_company_id","jobs_job_id"};
//            e = createXmlObj(doc,"person", args,
//                    ((Integer)i.getValue().getPerson_id()).toString(),
//                    i.getValue().getFirst_name(),
//                    i.getValue().getLast_name(),
//                    i.getValue().getLogin(),
//                    i.getValue().getPassword(),
//                    i.getValue().getEmail(),
//                    ((Float)i.getValue().getRating()).toString(),
//                    ((Integer)i.getValue().getAge()).toString(),
//                    i.getValue().getStatus(),
//                    ((Integer)i.getValue().getCompanies_company_id()).toString(),
//                    ((Integer)i.getValue().getJobs_job_id()).toString()
//            );
//            subRoot.appendChild(e);
//        }
//        root.appendChild(subRoot);
//
////        subRoot = createElement(doc, "Countries", null);
////        for(Map.Entry<String, Country> i: Storage.getCountries()){
////            String[] args = {"CountryId", "CountryName", "RegionId"};
////            e = createXmlObj(doc,"Country", args,
////                    i.getValue().getCountryId(),
////                    i.getValue().getCountryName(),
////                    ((Long)i.getValue().getRegionId()).toString());
////            subRoot.appendChild(e);
////        }
////        root.appendChild(subRoot);
////
////        subRoot = createElement(doc, "Locations", null);
////        for(Map.Entry<Long, Location> i: Storage.getLocations()){
////            String[] args = {"LocationId", "Adress", "City","CountryId","PostalCode"};
////            e = createXmlObj(doc,"Location", args,
////                    ((Long)i.getValue().getLocationId()).toString(),
////                    i.getValue().getAdress(),
////                    i.getValue().getCity(),
////                    i.getValue().getCountryId(),
////                    i.getValue().getPostalCode());
////            subRoot.appendChild(e);
////        }
////        root.appendChild(subRoot);
////
////        subRoot = createElement(doc, "Departments", null);
////        for(Map.Entry<Long, Department> i: Storage.getDepartments()){
////            String[] args = {"DepId", "LocationId", "ManagerId","Name"};
////            e = createXmlObj(doc,"Department", args,
////                    ((Long)i.getValue().getDepId()).toString(),
////                    ((Long)i.getValue().getLocationId()).toString(),
////                    ((Long)i.getValue().getManagerId()).toString(),
////                    i.getValue().getName());
////            subRoot.appendChild(e);
////        }
////        root.appendChild(subRoot);
////
////        subRoot = createElement(doc, "Jobs", null);
////        for(Map.Entry<String, Job> i: Storage.getJobs()){
////            String[] args = {"JobId", "JobTitle", "MaxSalary","MinSalary"};
////            e = createXmlObj(doc,"Job", args,
////                    i.getValue().getJobId(),
////                    i.getValue().getJobTitle(),
////                    ((Long)i.getValue().getMaxSalary()).toString(),
////                    ((Long)i.getValue().getMinSalary()).toString());
////            subRoot.appendChild(e);
////        }
////        root.appendChild(subRoot);
//
//    }
//
//    private Document docInit(String fileName) throws FileNotFoundException{
//        try {
//            File fXmlFile = new File(fileName);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(fXmlFile);
//            doc.getDocumentElement().normalize();
//            return doc;
//        }catch (FileNotFoundException e){
//            throw new FileNotFoundException();
//        }
//        catch (ParserConfigurationException e){
//            e.printStackTrace();
//            return null;
//        }catch (IOException e){
//            e.printStackTrace();
//            return null;
//        }catch (SAXException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    private Map<Integer, Person> fillPersons(NodeList nList){
//        Map<Integer, Person> persons = new HashMap<Integer, Person>();
//        Person p;
//
//        for (int i = 0; i < nList.getLength(); i++) {
//            //System.err.println(nList.item(i).getNodeName());
//            if (nList.item(i).getNodeName().equals("person")){
//                Node nNode = nList.item(i);
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//                    Element eElement = (Element) nNode;
//                    p = new Person(Integer.parseInt(getTagValue("person_id", eElement)),getTagValue("first_name", eElement),getTagValue("last_name", eElement),
//                           Float.parseFloat(getTagValue("rating", eElement)),Integer.parseInt(getTagValue("age", eElement)),getTagValue("status", eElement),getTagValue("login", eElement),
//                            getTagValue("password", eElement), getTagValue("email", eElement),Integer.parseInt(getTagValue("companies_company_id", eElement)),
//                           Integer.parseInt(getTagValue("jobs_job_id", eElement)) );
//                    persons.put(p.getPerson_id(), p);
//                }
//            }
//        }
//        return persons;
//    }
//
//    private String getTagValue(String sTag, Element eElement) {
//        try{
//            NodeList nList = eElement.getChildNodes(); //.getElementsByTagName(sTag).item(0)
//            for (int i = 0; i < nList.getLength(); i++){ //Node n = nList.item(i);
//                if (nList.item(i).getNodeName().equals(sTag)){
//                    return nList.item(i).getChildNodes().item(0).getNodeValue(); //.getTextContent();//
//                }	//Sergey Pankratov: ������ �����, ��� ��� �������� ����������(complete)
//            }	//Node nValue = (Node) nlList.item(0);
//            return null; //return nValue.getNodeValue();
//        }catch (Exception e){
//            return null;
//        }
//    }
//}
