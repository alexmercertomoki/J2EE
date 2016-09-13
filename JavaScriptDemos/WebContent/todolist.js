function addToList(where){
    var inputBoxEl   = document.getElementById("item");
    var itemText = inputBoxEl.value;
    
    if (itemText == "") return;
    
    inputBoxEl.value = "";
    
    //We disable the buttons until the animation has finished.
    document.getElementById("addToTopButton").disabled    = true;
    document.getElementById("addToBottomButton").disabled = true;
    
    //We create a row element in our list table. In this row we will store the new item.
    var trEl = document.createElement("tr");
    
    //We add the erase button to the row.
    var tdEl = document.createElement("td");
    var deleteButton    = document.createElement("input");
    deleteButton.type   = "button";
    deleteButton.value  = "X";
    deleteButton.onclick = deleteItem;
    tdEl.appendChild(deleteButton);
    trEl.appendChild(tdEl);
    
    //We add the item to the row
    var tdEl = document.createElement("td");
    var text = document.createTextNode(itemText);
    tdEl.appendChild(text);
    trEl.appendChild(tdEl);
    var tableList = document.getElementById("list");
    
    //We set it's visibility as hidden first. When the animation has finished we set back its
    //visibility to true
    trEl.style.visibility = "hidden";
    if (where == "bottom") {
        tableList.appendChild(trEl);
    } else if (where == "top") {
        tableList.insertBefore(trEl, tableList.firstChild);
    }
    
    //We create our animated text element.
    var startingPos = findPos(inputBoxEl);
    var endingPos = findPos(tdEl);
    var bodyEl = document.getElementsByTagName("body")[0];
    var movingEl = document.createElement("div");
    var text = document.createTextNode(itemText);
    movingEl.appendChild(text);
    movingEl.id = "movingEl";
    movingEl.style.position = "absolute";
    movingEl.style.left = startingPos[0]+"px";
    movingEl.style.top = startingPos[1]+"px";
    bodyEl.appendChild(movingEl);
    moveIt(endingPos[0],endingPos[1]);
    
    updateItemCounter();
}

//This method updates in the HTML Doc the total number of items in the list.
//It counts the number of rows in the table to calculate the total number of items.
function updateItemCounter(){
    //We update the number of items
    var tableList       = document.getElementById("list");
    var numberOfItemsEl = document.getElementById("numberOfItems");
    var nItems          = tableList.childNodes.length;
    var text            = document.createTextNode(nItems);
    numberOfItemsEl.replaceChild(text,numberOfItemsEl.firstChild);

}

//This method is launched when the user click the 'X' button to delete an item.
//This method erases the row of the table where the button that invoke the event is located.
function deleteItem(){
    //We get the element that launched the event
    var invoker     = this;
    var tdParent    = invoker.parentNode;
    var trParent    = tdParent.parentNode;
    var tableParent = trParent.parentNode;
    tableParent.removeChild(trParent);
    updateItemCounter();
}

//This method moves the div element movingEl and moves it to finalx, finaly position.
function moveIt(finalX,finalY){
    var element=document.getElementById("movingEl");
    //If we have reach our final pos, we stop the animation and return.
    if (parseInt(element.style.top) >= finalY && parseInt(element.style.left) <= finalX) {
        stopAnimation();
        return;
    }
    
    //We move to the left only if we have not reach the finalx.
    if (parseInt(element.style.left)>finalX) {
        element.style.left = parseInt(element.style.left)-3+'px';
    }
    
    //We move to the down only if we have not reach the finaly.
    if (parseInt(element.style.top)<finalY) {
        element.style.top = parseInt(element.style.top)+6+'px';
    }
    
    //We call moveIt in 30msec
    setTimeout("moveIt("+finalX+","+finalY+")",300);
}

//This method removes the div movingEl
//Then it makes visible all the items in the table. Remember that before starting the animation
//we hide the item in the table that was going to be animated.
function stopAnimation(){
    //We remove the movingEl
    var bodyEl   = document.getElementById("body");
    var movingEl = document.getElementById("movingEl");
    bodyEl.removeChild(movingEl);
    
    //We make visible all the items of the list (since we don't know if it's the top or bottom)
    var listEl = document.getElementById("list");
    var listChilds = listEl.childNodes;
    for (var i=0; i<listChilds.length; i++) {
        listChilds[i].style.visibility="visible";
    }
    
    //We enable the buttons again.
    document.getElementById("addToTopButton").disabled=false;
    document.getElementById("addToBottomButton").disabled=false;
}

//Method to find the position in the screen of a certain element.
//It return an array with pos=[x,y]
function findPos(obj) {
    var curleft = curtop = 0;
    if (obj.offsetParent) {
        do {
            curleft += obj.offsetLeft;
            curtop += obj.offsetTop;
        } while (obj = obj.offsetParent);
    }
    return [curleft,curtop];
}
