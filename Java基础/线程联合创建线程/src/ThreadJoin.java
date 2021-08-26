public class ThreadJoin implements Runnable{
    Thread joinThreadD,joinThreadW;
    public void setJoinThreadDriver(Thread t){
        joinThreadD=t;
    }
    public void setJoinThreadWorker(Thread s){
        joinThreadW=s;
    }
    public void run(){
        if(Thread.currentThread().getName().equals("仓库管理员")){
            System.out.println(Thread.currentThread().getName()+"正在为"+joinThreadW.getName()+"打开仓库");
            try{
                Thread.sleep(2000);
                joinThreadW.start();
                joinThreadW.join();
            }
            catch(InterruptedException ignored){}
        }
         if(Thread.currentThread()==joinThreadW){
            System.out.println(joinThreadW.getName()+"正在搬运货物，请稍等");
            try {
                Thread.sleep(2000);
                joinThreadD.start();
                joinThreadD.join();
            }
            catch (InterruptedException ignored){}
         }
        if(Thread.currentThread()==joinThreadD) {
            System.out.println("已经装货完毕，开始发车");

        }
    }
}
