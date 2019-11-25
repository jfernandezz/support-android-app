package service;

public class RunMy implements Runnable {
    @Override
    public void run() {
        try {
            String ret= HttpUrlConnectionMM.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
