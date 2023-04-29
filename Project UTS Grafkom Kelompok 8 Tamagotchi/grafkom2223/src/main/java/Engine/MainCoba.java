package Engine;

import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;

public class MainCoba {
    private Window window = new Window(1000, 1000, "Hello World");

    MouseInput mouseInput;

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());

    Pohon pohon = new Pohon(camera, projection);

     Bangunan1 bangunan1 = new Bangunan1(camera, projection);
     Bangunan2 bangunan2 = new Bangunan2(camera, projection);

     Wawatchi wawatchi = new Wawatchi(camera,projection);

    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0.0f, 0.0f, 3.0f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();
        pohon.init();
        wawatchi.init();
//        wawatchi.scaleObject(0.1f,0.1f,0.1f);
        wawatchi.translateObject(0.7f,-0.13f,0.0f);

        // kalo mau coba draw bangunan yang kalian dh buat tinggal diinit dlu, tapi harus new dlu di atas
        bangunan1.init();
        bangunan1.translateObject(-1.0f,0.0f,-2.0f);
        bangunan1.scaleObject(2.0f,2.0f,2.0f);
        bangunan2.init();
    }

    public void input(){
        // camera
        if (window.isKeyPressed(GLFW_KEY_5)){
            camera.moveBackwards(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_6)){
            camera.moveForward(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_7)){
            camera.moveLeft(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_8)){
            camera.moveRight(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_9)){
            camera.moveUp(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_0)){
            camera.moveDown(0.01f);
        }
        if (window.isKeyPressed(GLFW_KEY_KP_8)) {
            camera.addRotation((float) Math.toRadians(0.1f),0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_KP_5)){
            camera.addRotation((float) Math.toRadians(-0.1f),0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_KP_4)){
            camera.addRotation(0.0f, (float) Math.toRadians(0.1f));
        }
        if (window.isKeyPressed(GLFW_KEY_KP_6)){
            camera.addRotation(0.0f,(float) Math.toRadians(-0.1f));
        }


        if(window.isKeyPressed(GLFW_KEY_Q)) {
            Vector3f tempCenterPoint1 = pohon.objectsPohon.get(0).updateCenterPoint();
            pohon.objectsPohon.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            pohon.objectsPohon.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
            pohon.objectsPohon.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);

            Vector3f tempCenterPoint2 = bangunan1.objectsBangunan.get(0).updateCenterPoint();
            bangunan1.objectsBangunan.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            bangunan1.objectsBangunan.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
            bangunan1.objectsBangunan.get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,tempCenterPoint2.z);
        }

        if(window.isKeyPressed(GLFW_KEY_E)) {
            Vector3f tempCenterPoint1 = pohon.objectsPohon.get(0).updateCenterPoint();
            pohon.objectsPohon.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            pohon.objectsPohon.get(0).rotateObject(-0.01f, 0.0f, 0.0f, 1.0f);
            pohon.objectsPohon.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);

            Vector3f tempCenterPoint2 = bangunan1.objectsBangunan.get(0).updateCenterPoint();
            bangunan1.objectsBangunan.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            bangunan1.objectsBangunan.get(0).rotateObject(-0.01f, 0.0f, 0.0f, 1.0f);
            bangunan1.objectsBangunan.get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,tempCenterPoint2.z);
        }

        if(window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tempCenterPoint1 = pohon.objectsPohon.get(0).updateCenterPoint();
            pohon.objectsPohon.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            pohon.objectsPohon.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
            pohon.objectsPohon.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);

            Vector3f tempCenterPoint2 = bangunan1.objectsBangunan.get(0).updateCenterPoint();
            bangunan1.objectsBangunan.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            bangunan1.objectsBangunan.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
            bangunan1.objectsBangunan.get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,tempCenterPoint2.z);
        }

        if(window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tempCenterPoint1 = pohon.objectsPohon.get(0).updateCenterPoint();
            pohon.objectsPohon.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            pohon.objectsPohon.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
            pohon.objectsPohon.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);

            Vector3f tempCenterPoint2 = bangunan1.objectsBangunan.get(0).updateCenterPoint();
            bangunan1.objectsBangunan.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            bangunan1.objectsBangunan.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
            bangunan1.objectsBangunan.get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,tempCenterPoint2.z);
        }

        if(window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f tempCenterPoint1 =  pohon.objectsPohon.get(0).updateCenterPoint();
            pohon.objectsPohon.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            pohon.objectsPohon.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
            pohon.objectsPohon.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);

            Vector3f tempCenterPoint2 = bangunan1.objectsBangunan.get(0).updateCenterPoint();
            bangunan1.objectsBangunan.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            bangunan1.objectsBangunan.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
            bangunan1.objectsBangunan.get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,tempCenterPoint2.z);
        }

        if(window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f tempCenterPoint1 =  pohon.objectsPohon.get(0).updateCenterPoint();
            pohon.objectsPohon.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            pohon.objectsPohon.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
            pohon.objectsPohon.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);

            Vector3f tempCenterPoint2 = bangunan1.objectsBangunan.get(0).updateCenterPoint();
            bangunan1.objectsBangunan.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            bangunan1.objectsBangunan.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
            bangunan1.objectsBangunan.get(0).translateObject(tempCenterPoint2.x, tempCenterPoint2.y,tempCenterPoint2.z);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)){
            wawatchi.objectTorus.get(0).translateObject(0.0f,0.001f,0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            wawatchi.objectTorus.get(0).translateObject(-0.001f,0.0f,0.0f);
            Vector3f tempCenterPoint1 = wawatchi.objectTorus.get(0).updateCenterPoint();
            wawatchi.objectTorus.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectTorus.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
            wawatchi.objectTorus.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
        }
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            // ini untuk background colornya
            glClearColor(0.0f, 1.0f, 0.5f, 1.0f); // direset, tapi hanya 1 frame maka perlu diloop
            GL.createCapabilities();
            input();
//            pohon.loop();

            // disini panggil bangunan1.loop()
            bangunan1.loop();

//            bangunan2.loop();

            wawatchi.loop();
            // restore state
            glDisableVertexAttribArray(0);
            // poll fow window events
            // the key callback above will only be invoked during this call
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new MainCoba().run();
    }
}
