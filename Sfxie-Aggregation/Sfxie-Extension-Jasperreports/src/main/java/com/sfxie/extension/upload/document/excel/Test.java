package com.sfxie.extension.upload.document.excel;

import java.io.FileInputStream;
import java.io.InputStream;

import com.sfxie.extension.upload.document.excel.header.HeaderDefEntity;
import com.sfxie.extension.upload.document.excel.header.HeaderDefLinkedList;
import com.sfxie.extension.upload.document.excel.header.java.EHDDate;
import com.sfxie.extension.upload.document.excel.header.java.EHDDoublePersentage;
import com.sfxie.extension.upload.document.excel.header.java.EHDString;
import com.sfxie.extension.upload.document.excel.visitor.DefaultHeaderDefVisitor;

public class Test {
	public static void main(String[] args) {
        try {
        	ExcelReader excelReader = new ExcelReader();
        	
            /*// 对读取Excel表格标题测试
            InputStream is = new FileInputStream("D:\\workspace\\MyEclipse8.6\\SZPS\\WebRoot\\WEB-INF\\report\\SZPS_TRL_TrailerDeparture_ImportTemplate.xls");
            String[] title = excelReader.readExcelTitle(is);
            System.out.println("获得Excel表格的标题:");
            for (String s : title) {
                System.out.print(s + " ");
            }

            // 对读取Excel表格内容测试
            InputStream is2 = new FileInputStream("D:\\workspace\\MyEclipse8.6\\SZPS\\WebRoot\\WEB-INF\\report\\SZPS_TRL_TrailerDeparture_ImportTemplate.xls");
            Map<Integer, String> map = excelReader.readExcelContent(is2);
            System.out.println("获得Excel表格的内容:");
            for (int i = 1; i <= map.size(); i++) {
                System.out.println(map.get(i));
            }*/
        	 
        	 /*//excel的第一行数据列定义
        	 HeaderDefLinkedList headerCellLinkeList1 = new HeaderDefLinkedList();
        	 headerCellLinkeList1.setValidatedRowIndex(2);
        	 headerCellLinkeList1.setDataType("single");
        	 HeaderDefEntity headerCellEntity11 = new EHDString("condition.wkfTrailerDeparture.orderId","委托单号","B");
        	 HeaderDefEntity headerCellEntity12 = new EHDDouble("condition.wkfTrailerDeparture.nsFlag","发车类型","D");
        	 HeaderDefEntity headerCellEntity13 = new EHDString("condition.wkfTrailerDeparture.transportId","提运单号","F");
        	 HeaderDefEntity headerCellEntity14 = new EHDString("condition.wkfTrailerDeparture.isCsDeclare","长沙报关","H");
        	 HeaderDefEntity headerCellEntity15 = new EHDString("condition.wkfTrailerDeparture.isTransmit","我司转/清关","J");
        	 HeaderDefEntity headerCellEntity16 = new EHDString("condition.wkfTrailerDeparture.clientNature","客户性质","M");
        	 HeaderDefEntity headerCellEntity17 = new EHDString("condition.wkfTrailerDeparture.deptStation","发运站","O");
        	 HeaderDefEntity headerCellEntity18 = new EHDString("condition.wkfTrailerDeparture.transFrom","发运人","R");
        	 HeaderDefEntity headerCellEntity19 = new EHDString("condition.wkfTrailerDeparture.destStation","到达站","T");
        	 HeaderDefEntity headerCellEntity110 = new EHDString("condition.wkfTrailerDeparture.so","SO","V");
        	 HeaderDefEntity headerCellEntity111 = new EHDString("condition.wkfTrailerDeparture.shipName","船名","X");
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity11);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity12);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity13);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity14);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity15);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity16);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity17);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity18);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity19);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity110);
        	 headerCellLinkeList1.addHeaderDefEntity(headerCellEntity111);
        	//excel的第二行数据列定义
        	 HeaderDefLinkedList headerCellLinkeList2 = new HeaderDefLinkedList();
        	 headerCellLinkeList2.setValidatedRowIndex(4);
        	 headerCellLinkeList2.setDataType("single");
        	 HeaderDefEntity headerCellEntity21 = new HeaderDefEntity("condition.wkfTrailerDeparture.voyNo","航次","B");
        	 HeaderDefEntity headerCellEntity22 = new HeaderDefEntity("condition.wkfTrailerDeparture.unloadPort","卸货港","D");
        	 HeaderDefEntity headerCellEntity23 = new HeaderDefEntity("condition.wkfTrailerDeparture.transshipPort","中转港","F");
        	 HeaderDefEntity headerCellEntity24 = new HeaderDefEntity("condition.wkfTrailerDeparture.destinationPort","目的港","H");
        	 HeaderDefEntity headerCellEntity25 = new HeaderDefEntity("condition.wkfTrailerDeparture.deputePerson","委托人","J");
        	 HeaderDefEntity headerCellEntity26 = new HeaderDefEntity("condition.wkfTrailerDeparture.deputeLinkman","联系人","M");
        	 HeaderDefEntity headerCellEntity27 = new HeaderDefEntity("condition.wkfTrailerDeparture.deputePhone","联络电话","O");
        	 HeaderDefEntity headerCellEntity28 = new HeaderDefEntity("condition.wkfTrailerDeparture.receivePerson","接收人","R");
        	 HeaderDefEntity headerCellEntity29 = new HeaderDefEntity("condition.wkfTrailerDeparture.sectionDate","截重期","T");
        	 headerCellEntity29.setValueType(HeaderDefEntity.DATE);
        	 HeaderDefEntity headerCellEntity210 = new HeaderDefEntity("condition.wkfTrailerDeparture.cabinetAskedDate","提柜日期","V");
        	 headerCellEntity210.setValueType(HeaderDefEntity.DATE);
        	 HeaderDefEntity headerCellEntity211 = new HeaderDefEntity("condition.wkfTrailerDeparture.weightTime","重下时间","X");
        	 headerCellEntity211.setValueType(HeaderDefEntity.DATE);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity21);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity22);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity23);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity24);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity25);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity26);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity27);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity28);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity29);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity210);
        	 headerCellLinkeList2.addHeaderDefEntity(headerCellEntity211);
        	 
        	//excel的第三行数据列定义
        	 HeaderDefLinkedList headerCellLinkeList3 = new HeaderDefLinkedList();
        	 headerCellLinkeList3.setValidatedRowIndex(6);
        	 headerCellLinkeList3.setDataType("single");
        	 HeaderDefEntity headerCellEntity31 = new HeaderDefEntity("condition.wkfTrailerDeparture.closeDate","截关期","B");
        	 HeaderDefEntity headerCellEntity32 = new HeaderDefEntity("condition.wkfTrailerDeparture.sendTime","发车时间","D");
        	 HeaderDefEntity headerCellEntity33 = new HeaderDefEntity("condition.wkfTrailerDeparture.remark","备注","F");
        	 HeaderDefEntity headerCellEntity34 = new HeaderDefEntity("condition.wkfTrailerDeparture.noticeStatus","发车状态","H");
        	 headerCellLinkeList3.addHeaderDefEntity(headerCellEntity31);
        	 headerCellLinkeList3.addHeaderDefEntity(headerCellEntity32);
        	 headerCellLinkeList3.addHeaderDefEntity(headerCellEntity33);
        	 headerCellLinkeList3.addHeaderDefEntity(headerCellEntity34);
        	 
        	 
        	 //excel的第四行数据列定义
        	 HeaderDefLinkedList headerCellLinkeList4 = new HeaderDefLinkedList();
        	 headerCellLinkeList4.setValidatedRowIndex(12);
        	 headerCellLinkeList4.setDataType("list");
        	 HeaderDefEntity headerCellEntity41 = new HeaderDefEntity("rowNumber","序号","B");
        	 HeaderDefEntity headerCellEntity42 = new HeaderDefEntity("orderId","委托单号","C");
        	 HeaderDefEntity headerCellEntity43 = new HeaderDefEntity("cabinetOwner","箱属公司","E");
        	 HeaderDefEntity headerCellEntity44 = new HeaderDefEntity("cabinetNo","柜号","G");
        	 HeaderDefEntity headerCellEntity45 = new HeaderDefEntity("containerType","柜型","I");
        	 HeaderDefEntity headerCellEntity46 = new HeaderDefEntity("isEmpty","空重","K");
        	 HeaderDefEntity headerCellEntity47 = new HeaderDefEntity("cargoName","货名","L");
        	 HeaderDefEntity headerCellEntity48 = new HeaderDefEntity("netWeight","货重(KGS)","N");
        	 HeaderDefEntity headerCellEntity49 = new HeaderDefEntity("shipCoLock","船公司封","P");
        	 HeaderDefEntity headerCellEntity410 = new HeaderDefEntity("customLock","海关封","Q");
        	 HeaderDefEntity headerCellEntity411 = new HeaderDefEntity("railwaySeal","铁路封","S");
        	 HeaderDefEntity headerCellEntity412 = new HeaderDefEntity("inspecSeal","商检封","U");
        	 HeaderDefEntity headerCellEntity413 = new HeaderDefEntity("wagonNo","车皮号","W");
        	 HeaderDefEntity headerCellEntity414 = new HeaderDefEntity("goodsTicketNo","货票号","Y");
        	 HeaderDefEntity headerCellEntity415 = new HeaderDefEntity("remark","备注","Z");
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity41);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity42);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity43);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity44);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity45);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity46);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity47);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity48);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity49);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity410);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity411);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity412);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity413);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity414);
        	 headerCellLinkeList4.addHeaderDefEntity(headerCellEntity415);
        	 
        	 excelReader.getHeaderDefinitionList().add(headerCellLinkeList1);
        	 excelReader.getHeaderDefinitionList().add(headerCellLinkeList2);
        	 excelReader.getHeaderDefinitionList().add(headerCellLinkeList3);
        	 excelReader.getHeaderDefinitionList().add(headerCellLinkeList4);*/
        	
        	
//        	HeaderDefLinkedList headerCellLinkeList1 = new HeaderDefLinkedList();
//	       	headerCellLinkeList1.setValidatedRowIndex(1);
//	       	headerCellLinkeList1.setDataType("single");
//	       	HeaderDefEntity headerCellEntity11 = new EHDString("condition.wkfTrailerDeparture.orderId","名称:","A");
//	       	HeaderDefEntity headerCellEntity12 = new EHDDouble("condition.wkfTrailerDeparture.nsFlag","年纪:","C");
//	       	headerCellLinkeList1.addHeaderDefEntity(headerCellEntity11);
//	       	headerCellLinkeList1.addHeaderDefEntity(headerCellEntity12);
	       	 
	       	HeaderDefLinkedList headerCellLinkeList2 = new HeaderDefLinkedList();
	       	headerCellLinkeList2.setValidatedRowIndex(4);
	       	headerCellLinkeList2.setDataType("list");
	       	HeaderDefEntity headerCellEntity21 = new EHDString("condition.wkfTrailerDeparture.orderId","列1","A");
	       	HeaderDefEntity headerCellEntity22 = new EHDDoublePersentage("condition.wkfTrailerDeparture.nsFlag","列2","B",4);
	       	HeaderDefEntity headerCellEntity23 = new EHDDate("condition.wkfTrailerDeparture.nsFlag","日期","C");
	       	headerCellLinkeList2.addHeaderDefEntity(headerCellEntity21);
	       	headerCellLinkeList2.addHeaderDefEntity(headerCellEntity22);
	       	headerCellLinkeList2.addHeaderDefEntity(headerCellEntity23);
	       	 
	       	 
        	InputStream is = new FileInputStream("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveAdvert\\trunk\\src\\com\\golive\\extension\\upload\\document\\excel\\test.xlsx");
//        	excelReader.getHeaderDefinitionList().add(headerCellLinkeList1);
        	excelReader.getHeaderDefinitionList().add(headerCellLinkeList2);
         	excelReader.validateDocumentDefinition(is) ;
         	
         	excelReader.setHeaderDefVisitor(new DefaultHeaderDefVisitor());
         	excelReader.getData();
         	System.out.println(222);
        	 
        } catch (Exception e) {
//            System.out.println("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }
}
