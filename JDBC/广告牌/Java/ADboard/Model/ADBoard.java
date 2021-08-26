package ADboard.Model;
public class ADBoard {  //广告牌
    //数组advertisement每个单元存放一个广告（一个Advertisement对象）：
    private Advertisement [] advertisement=null;  
    int index = -1;
    public void setAdvertisement(Advertisement [] advertisement){
        this.advertisement = advertisement;
    }
    public Advertisement getAdvertisement(int i){//当前广告
        if(advertisement==null){
            return null;
        }
        if(advertisement.length==0){
            return null;
        }
        if(i>=advertisement.length||i<0){
            return null;
        }
        return advertisement[i];
    }
    public  Advertisement  nextAdvertisement() { //检验下一个广告是否存在
       index++;
       if(advertisement == null) {
          return null;
       }
       if(advertisement.length==0){
         return null;
       }
       if(index==advertisement.length) {
           index = 0; //循环 返回第一个广告位置
       }
       return advertisement[index];
    }
    public  Advertisement  previousAdvertisement() {  //检验之前广告是否存在
       index--;
       if(advertisement == null) {
          return null;
       }
       if(advertisement.length==0){
         return null;
       }
       if(index<0) {
           index =advertisement.length-1;//返回最后一个广告位置实现循环
       }
       return advertisement[index];
    }
}
