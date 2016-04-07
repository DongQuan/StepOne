/**
 * Created by jxuan on 16-4-7.
 */

//事件取消的三种方式
function cancelHandler(event) {
    var event = event || window.event;//IE
    if(event.preventDefault){
        event.preventDefault();
    }
    if(event.returnValue){
        //IE
        event.returnValue = false;
    }

    return false;
}