public class Homework {
    public static void main(String args[]){
        ThreadJoin a=new ThreadJoin();
        Thread driver=new Thread(a);
        Thread worker=new Thread(a);
        Thread administer=new Thread(a);
        driver.setName("货运司机");
        worker.setName("装运工");
        administer.setName("仓库管理员");
        a.setJoinThreadDriver(driver);
        a.setJoinThreadWorker(worker);
        administer.start();
    }
}
