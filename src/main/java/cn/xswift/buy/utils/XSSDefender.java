package cn.xswift.buy.utils;


public class XSSDefender {

	/**
	 * HTTP����
	 * @param HTMLContent
	 * @return
	 */
	public static String XSSDefenders(String HTMLContent) {
		return HTMLContent.replace("<", "&lt;")
						  .replace(">", "&gt;")
						  .replace("/", "&#x2f;");
	}
	
}
