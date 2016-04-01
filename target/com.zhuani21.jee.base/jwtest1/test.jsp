<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="/jwtest1/jquery-latest.js"></script>

<script type="text/javascript" src="/jwtest1/jwplayer/jwplayer.js"></script>
<!-- <script type="text/javascript" src="https://content.jwplatform.com/libraries/OhDwQt61.js"></script>
 -->
<script type="text/javascript">

jwplayer.key="CKJGB7HAGzHlUid3OOP1JeAsVgHrJ9yxSy5cPA";

window.onload = function(){
   jwplayer('container').setup({
		/*height: 600,  */
		primary: "html5", 
		width: "100%",
		aspectratio: "16:9",
		abouttext: "Vuclip",
		aboutlink: "http://www.vuclip.com",
		displaytitle: false,
		stretching: "fill",
		/* file:"levisu.mp4", */
        playlist: [{
		    sources: [
			     { file: "/jwtest1/lumiabuyback.mp4" , type: 'mp4', label: "100" },
				 { file: "/jwtest1/lumiabuyback.mp4" , type: 'mp4', label: "350" },
				 { file: "/jwtest1/lumiabuyback.mp4" , type: 'mp4', label: "HD" }
			]
		}],
	advertising: {
    	client: 'vast',
		schedule: {
      		preroll: {
				offset: 'pre',
				tag: '${tagLink}'
      		}
		}
	}
});

}

</script>

</head>

<body>

	<div id="container">aaaaaaa</div>
</body>
</html>