$(function(){'use strict';var $page=$('#main'),options={debug:true,prefetch:true,cacheLength:4,onStart:{duration:350,render:function($container){$container.addClass('is-exiting');smoothState.restartCSSAnimations();}},onReady:{duration:0,render:function($container,$newContent){$container.removeClass('is-exiting');$container.html($newContent);}}},smoothState=$page.smoothState(options).data('smoothState');});