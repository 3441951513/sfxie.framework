package com.sfxie.test.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.ParserConfigurationException;

import com.sfxie.test.xml.SfieEntity.SfxieEntity;
import com.sfxie.utils.XmlUtils;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="response")
public class SfxieResponse extends Response<SfxieEntity> {

    @XmlElement(name="data",type=SfxieData.class)
	@Override
	public Data<SfxieEntity> getData() {
		if(data==null){
			data = new SfxieData();
		}
		return data;
	}

	@Override
	public void setData(Data<SfxieEntity> data) {
		this.data = data;
	}

	
	public static void main(String[] args) {
		SfxieResponse sfxieResponse = new SfxieResponse();
		SfxieEntity sfxieEntity = new SfxieEntity();
		sfxieEntity.setName("sfxie");
		SfxieData data = (SfxieData) sfxieResponse.getData();
		data.getList().add(sfxieEntity);
		data.setAge("age");
		try {
			System.out.println(XmlUtils.serializerXmlString(sfxieResponse));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String dd = XmlUtils.serializerXmlString(sfxieResponse);
			XmlUtils.unserializer(SfxieResponse.class, dd);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
