public class PageGenerator{
	private static String htmlCode;
	private static void setHtmlCode(){
		
		
		htmlCode = "<!DOCTYPE html>"+
					"<html lang=\"en\">"+
					"<head>"+
						"<meta charset=\"UTF-8\">"+
						"<title>TestJavaServerPage3</title>"+
					"</head>"+
					"<body>"+
					
					"<script>setInterval(\'window.location.reload()\', 1000);</script>"+
					"</body>"+
					"</html>";
			}
	public static String generateHtmlCode(){
		if(htmlCode == null){
			setHtmlCode();
		}
		return htmlCode;
	}
}