/**
 * 
 */
window.onload=function(){
	var oUl = document.getElementById('list');
	var aH2 = oUl.getElementsByTagName('span');
	var aUl = oUl.getElementsByTagName('ul');
	var aLi = null;
	var arrLi = [];
	var oldLi = null;
	var n_onOff
	for(var i=0;i<aUl.length;i++)
	{
		aLi=aUl[i].getElementsByTagName('a');
		for(var j=0;j<aLi.length;j++){
			arrLi.push(aLi[j]);
		}
	}
	for(var i=0;i<aH2.length;i++){
		
		aH2[i].onOff=true;

		aH2[i].index=i;
		
		aH2[i].onclick=function(){
			 n_onOff= this.onOff;
			for(var i=0;i<aUl.length;i++){
				aH2[i].className='';
				aUl[i].style.display='none';
				aH2[i].onOff=true;
			}
			this.onOff=n_onOff;
			if(this.onOff){
				this.className='hover';
				aUl[this.index].style.display='block';
				this.onOff=false;
				
			}else{
				this.className='';
				aUl[this.index].style.display='none';
				this.onOff=true;
			}
		};
	}
	for(var i=0;i<arrLi.length;i++){
		arrLi[i].onclick=function(){
			for(var i=0;i<arrLi.length;i++)
			{
				arrLi[i].className='';
			}
			this.className='over';
		};
	}
	//alert(1);
	
}