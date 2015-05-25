package DropBox;

/**
 * Created by svetlana on 29.03.15.
 */

//import DropBox.TestRegDropBoxUser;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int userCount = 2;
        for (int i = 0; i < userCount; i++) {
            DropBoxRegistration registration = new DropBoxRegistration();
            registration.setup();
            registration.captchaAppears();
            registration.userRegistration();
            registration.tearDown();
        }
    }

}
