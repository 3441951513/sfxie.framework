package com.sfxie.website.modules.api3.mall.model.querypaystate.response;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.utils.XmlUtils;
import com.sfxie.website.modules.api3.common.model.response.Response;

@XmlRootElement(name = "response")
public class PayStateResponse extends Response {

	private PayStateData data;

	@XmlElement(name="data")
	public PayStateData getData() {
		return data;
	}

	public void setData(PayStateData data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<response website=\"http://xxx\">"+
							"	<error type=\"false\" code=\"\" note=\"\" servertime=\"2015-12-01 11：25：20\"/>"+
							"	<data total=\"1\">"+
							"		<goods id=\"1\" name=\"非常卡农\" attribute=\"2\" typename=\"类1\" typeid=\"1\" code=\"2120\""+
							"		          price=\"2000\" original_price=\"20\" video_url=\"http://xxx\" unit=\"元/片\" stock=\"20\" note=\"\" qrcode=\"\" smallCover=\"s.jpg\" bigCover=\"b.jpg\" allow_buy_quantity=\"1\""+
							"		day_allow_limit=\"1\" logo_url=\"http://xxxx\"  over_allow_tip=\"xxxx\" "+
							"		imagetotal=\"3\" >"+
							"		<images path1=\"11.jpg\" path2=\"12.jpg\" />"+
							"		<images path1=\"21.jpg\" path2=\"22.jpg\" />"+
							"		<images path1=\"31.jpg\" path2=\"32.jpg\" />"+
							"		</goods>"+
							"	</data>"+
							"</response>";
		try {
			PayStateResponse purchaseDetailResponse = XmlUtils.unserializer(PayStateResponse.class, xmlString);
			System.out.println(purchaseDetailResponse);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
