<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>new_file</title>
<script type="text/javascript" src="loadscript.js"></script>
</head>
<body>
	<div id="msat-adwrap"></div>
	<div id="msat-adwrap2"></div>
	<script type="text/javascript">
		loadScript.add({//google adsense  
			url : 'http://pagead2.googlesyndication.com/pagead/show_ads.js',
			container : 'msat-adwrap',
			init : function() {
				google_ad_client = "ca-pub-8341041798477935";
				/* 250x250 rich */
				google_ad_slot = "6041287146";
				google_ad_width = 300;
				google_ad_height = 50;
			},
			callback : function() {
				console.log('msat-adwrap3');
			}
		}).execute();
	</script>
</body>
</html>
