package ADboard.Model;
public class ADBoard {  //�����
    //����advertisementÿ����Ԫ���һ����棨һ��Advertisement���󣩣�
    private Advertisement [] advertisement=null;  
    int index = -1;
    public void setAdvertisement(Advertisement [] advertisement){
        this.advertisement = advertisement;
    }
    public Advertisement getAdvertisement(int i){//��ǰ���
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
    public  Advertisement  nextAdvertisement() { //������һ������Ƿ����
       index++;
       if(advertisement == null) {
          return null;
       }
       if(advertisement.length==0){
         return null;
       }
       if(index==advertisement.length) {
           index = 0; //ѭ�� ���ص�һ�����λ��
       }
       return advertisement[index];
    }
    public  Advertisement  previousAdvertisement() {  //����֮ǰ����Ƿ����
       index--;
       if(advertisement == null) {
          return null;
       }
       if(advertisement.length==0){
         return null;
       }
       if(index<0) {
           index =advertisement.length-1;//�������һ�����λ��ʵ��ѭ��
       }
       return advertisement[index];
    }
}
