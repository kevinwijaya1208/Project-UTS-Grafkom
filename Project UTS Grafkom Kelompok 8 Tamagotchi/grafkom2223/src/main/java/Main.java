import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(1000, 1000, "Hello World");

    MouseInput mouseInput;

    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());
    Wawatchi wawatchi = new Wawatchi(camera, projection);
    Tamatchi tamatchi = new Tamatchi(camera, projection);
    Hikotchi hikotchi = new Hikotchi(camera, projection);

    Bangunan1 bangunan1 = new Bangunan1(camera,projection);
    Bangunan2 bangunan2 = new Bangunan2(camera, projection);
    Bangunan3 bangunan3 = new Bangunan3(camera, projection);
    boolean gantiGambar = false;
    int gambarSekarang = 0;
    boolean roleWawatchi = true;
    boolean roleTamatchi = true;
    boolean roleHikotchi = true;
    public void init() {
        window.init();
        GL.createCapabilities();
        camera.setPosition(0.0f,0.0f,4.0f);
        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));
        glEnable(GL_DEPTH_TEST);
        mouseInput = window.getMouseInput();

        wawatchi.init();
        wawatchi.scaleObject(0.8f,0.8f,0.8f);

        tamatchi.init();
        tamatchi.scaleObject(0.8f,0.8f,0.8f);

        hikotchi.init();

        bangunan1.init();

        bangunan2.init();

        bangunan3.init();

        wawatchi.translateObject(0.3f,-0.2f,0.8f);
        tamatchi.translateObject(1.0f, -0.43f, -0.1f);
        bangunan1.translateObject(-0.5f,0.0f,-2.0f);
        bangunan1.scaleObject(2.0f,2.0f,2.0f);
        bangunan2.scaleObject(2.0f,2.0f,2.0f);
        bangunan2.translateObject(0.0f,0.0f,-3.2f);
        bangunan3.translateObject(0.8f,0.0f,-2.0f);
        bangunan3.scaleObject(2.0f,2.0f,2.0f);
        bangunan3.rotateObject(-20f,0.0f,1.0f,0.0f);

        wawatchi.rotateObject(-7f, 0.0f, 1.0f, 0.0f);
        tamatchi.rotateObject(-7f,0.0f,1.0f,0.0f);
        hikotchi.rotateObject(40f,0.0f,1.0f,0.0f);
        hikotchi.rotateObject(30f, 1.0f, 0.0f, 0.0f);
        hikotchi.translateObject(-4.0f, 2.0f, -0.5f);
        bangunan1.objectsBangunan.get(0).rotateObject(0.5f,0.0f,1.0f,0.0f);
    }

    public void input() {
        // ini input untuk gerak secara bersamaan ketiga karakter
        if (roleWawatchi && roleTamatchi && roleHikotchi){
            // Rotate
            if(window.isKeyPressed(GLFW_KEY_Q)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(11).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_E)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(11).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 0.0f, 1.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, -1.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 0.0f, -1.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_W)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_S)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, -1.0f, 0.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_A)) {
                Vector3f tempCenterPoint1 =  wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_D)) {
                Vector3f tempCenterPoint1 =  wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, -1.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            // Translate
            if(window.isKeyPressed(GLFW_KEY_U)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.01f);
                tamatchi.objectsSphere.get(0).translateObject(0.0f,0.0f,0.01f);
                for (Object object: hikotchi.objectsSphere){
                    object.translateObject(0.0f,0.0f,0.01f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_O)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.0f, -0.01f);
                tamatchi.objectsSphere.get(0).translateObject(0.0f,0.0f,-0.01f);
                for (Object object: hikotchi.objectsSphere){
                    object.translateObject(0.0f,0.0f,-0.01f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_I)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.005f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(0.0f, 0.005f, 0.0f);
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            0f,
                            0.005f,
                            0f
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_K)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, -0.005f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(0.0f, -0.005f, 0.0f);
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            0f,
                            -0.005f,
                            0f
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_J)) {
                wawatchi.objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            -0.005f,
                            0f,
                            0f
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_L)) {
                wawatchi.objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            0.005f,
                            0f,
                            0f
                    );
                }
            }
        }

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

        // ini untuk ganti frame
        if (window.isKeyPressed(GLFW_KEY_R)){
            gambarSekarang = 0;
            roleWawatchi = true;
            roleTamatchi = true;
            roleHikotchi = true;
            gantiGambar = true;
        } else if (window.isKeyPressed(GLFW_KEY_T)){
            gambarSekarang = 1;
            roleWawatchi = true;
            roleTamatchi = false;
            roleHikotchi = false;
            gantiGambar = true;
        } else if (window.isKeyPressed(GLFW_KEY_F)){
            gambarSekarang = 2;
            roleWawatchi = false;
            roleTamatchi = true;
            roleHikotchi = false;
            gantiGambar = true;
        } else if (window.isKeyPressed(GLFW_KEY_G)){
            gambarSekarang = 3;
            roleWawatchi = false;
            roleTamatchi = false;
            roleHikotchi = true;
            gantiGambar = true;
        }

        // jika ingin menggerakkan wawatchi saja
        if (window.isKeyPressed(GLFW_KEY_1)){
            roleWawatchi = true;
            roleTamatchi = false;
            roleHikotchi = false;
        }

        // jika ingin menggerakkan tamatchi saja
        if (window.isKeyPressed(GLFW_KEY_2)){
            roleTamatchi = true;
            roleWawatchi = false;
            roleHikotchi = false;
        }

        // jika ingin menggerakkan hikotchi saja
        if (window.isKeyPressed(GLFW_KEY_3)){
            roleHikotchi = true;
            roleWawatchi = false;
            roleTamatchi = false;
        }

        // jika ingin menggerakkan ketiga karakternya
        if (window.isKeyPressed(GLFW_KEY_4)){
            roleWawatchi = true;
            roleTamatchi = true;
            roleHikotchi = true;
        }

        // input atau gerakan khusus untuk wawatchi
        if (roleWawatchi && !roleTamatchi && !roleHikotchi){
            // Rotate
            if(window.isKeyPressed(GLFW_KEY_Q)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(11).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);
            }

            if(window.isKeyPressed(GLFW_KEY_E)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(11).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 0.0f, 1.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);
            }

            if(window.isKeyPressed(GLFW_KEY_W)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            }

            if(window.isKeyPressed(GLFW_KEY_S)) {
                Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            }

            if(window.isKeyPressed(GLFW_KEY_A)) {
                Vector3f tempCenterPoint1 =  wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            }

            if(window.isKeyPressed(GLFW_KEY_D)) {
                Vector3f tempCenterPoint1 =  wawatchi.objectsSphere.get(0).updateCenterPoint();
                wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
                wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            }

            // Translate
            if(window.isKeyPressed(GLFW_KEY_U)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.01f);
            }

            if(window.isKeyPressed(GLFW_KEY_O)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.0f, -0.01f);
            }

            if(window.isKeyPressed(GLFW_KEY_I)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.005f, 0.0f);
            }

            if(window.isKeyPressed(GLFW_KEY_K)) {
                wawatchi.objectsSphere.get(0).translateObject(0.0f, -0.005f, 0.0f);
            }

            if(window.isKeyPressed(GLFW_KEY_J)) {
                wawatchi.objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
            }

            if(window.isKeyPressed(GLFW_KEY_L)) {
                wawatchi.objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
            }
            if (window.isKeyPressed(GLFW_KEY_UP)){
                wawatchi.objectTorus.get(0).translateObject(0.0f,0.01f,0.0f);
            }
            if (window.isKeyPressed(GLFW_KEY_LEFT)) {
                wawatchi.objectTorus.get(0).translateObject(-0.01f,0.0f,0.0f);
                Vector3f tempCenterPoint1 = wawatchi.objectTorus.get(0).updateCenterPoint();
                wawatchi.objectTorus.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
                wawatchi.objectTorus.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
                wawatchi.objectTorus.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            }

            if(window.isKeyPressed(GLFW_KEY_Z)) {
                for (Sphere sphere:  wawatchi.objectsSphere){
                    sphere.scaleObject(0.997f,0.997f,0.997f);
                }
                for (Torus torus:  wawatchi.objectTorus){
                    torus.scaleObject(0.997f,0.997f,0.997f);
                }
                for (Sphere sphere:  wawatchi.objectsLuar){
                    sphere.scaleObject(0.997f,0.997f,0.997f);
                }
                for (Object bezier:  wawatchi.titikBezier){
                    bezier.scaleObject(0.997f,0.997f,0.997f);
                }
                for (Object bezier:  wawatchi.titikBezier2){
                    bezier.scaleObject(0.997f,0.997f,0.997f);
                }
            }
            if(window.isKeyPressed(GLFW_KEY_X))
            {
                for (Sphere sphere:  wawatchi.objectsSphere){
                    sphere.scaleObject(1.001f,1.001f,1.001f);
                }
                for (Torus torus:  wawatchi.objectTorus){
                    torus.scaleObject(1.001f,1.001f,1.001f);
                }
                for (Sphere sphere:  wawatchi.objectsLuar){
                    sphere.scaleObject(1.001f,1.001f,1.001f);
                }
                for (Object bezier:  wawatchi.titikBezier){
                    bezier.scaleObject(1.001f,1.001f,1.001f);
                }
                for (Object bezier:  wawatchi.titikBezier2){
                    bezier.scaleObject(1.001f,1.001f,1.001f);
                }
            }

            if (window.isKeyPressed(GLFW_KEY_SPACE)) {
                wawatchi.isJumping = true;
            }

            if ( wawatchi.isJumping) {
                wawatchi.y += 0.0008f;
            }

            if ( wawatchi.y >= 0.18f){
                wawatchi.isJumping = false;
                wawatchi.isFalling = true;
            }

            if ( wawatchi.isFalling){
                wawatchi.y-= 0.001f;
            }
            if ( wawatchi.y <= 0.001f){
                wawatchi.isFalling = false;
            }

            if (window.isKeyPressed(GLFW_KEY_ENTER)){
                wawatchi.toTheMoon = true;
            }

            if ( wawatchi.toTheMoon){
                wawatchi.yToTheMoon += 0.001f;
                if ( wawatchi.yToTheMoon > 0.4f) {
                    wawatchi.toTheMoon = false;
                }
            }

            // Gerak Tangan Naik Turun
            if (window.isKeyPressed(GLFW_KEY_F1)){
                wawatchi.gerakTangan();
            }

            // Gerak kaki maju mundur
            if (window.isKeyPressed(GLFW_KEY_F2)){
                wawatchi.gerakKaki();
            }

            // Gerak kaki kiri kanan
            if (window.isKeyPressed(GLFW_KEY_F3)){
                wawatchi.gerakKakiKananKiri();
            }

            if (window.isKeyPressed(GLFW_KEY_F4)){
                wawatchi.gerakMaju();
                wawatchi.gerakTangan();
            }

            if (window.isKeyPressed(GLFW_KEY_F5)){
                wawatchi.gerakMundur();
                wawatchi.gerakTangan();
            }

            if (window.isKeyPressed(GLFW_KEY_H)){
                wawatchi.gerakKanan = true;
            }

            if (wawatchi.gerakKanan){
                wawatchi.timeGerakKanan += 0.001f;
            }

            if (wawatchi.timeGerakKanan >= 0.14f){
                wawatchi.gerakKanan = false;
                wawatchi.gerakKiri = true;
                wawatchi.timeGerakKanan = 0;
            }

            if ( wawatchi.gerakKiri){
                wawatchi.timeGerakKiri += 0.001f;
            }

            if ( wawatchi.timeGerakKiri >= 0.28f){
                wawatchi.gerakKiri = false;
                wawatchi.gerakKanan2 = true;
                wawatchi.timeGerakKiri = 0;
            }

            if ( wawatchi.gerakKanan2){
                wawatchi.timeGerakKanan2 += 0.001f;
            }

            if ( wawatchi.timeGerakKanan2 >= 0.28f){
                wawatchi.gerakKanan2 = false;
                wawatchi.gerakKiri = true;
                wawatchi.timeGerakKanan2 =0;
            }

            if (window.isKeyPressed(GLFW_KEY_Y)){
                wawatchi.gerakKiri = false;
                wawatchi.gerakKanan = false;
                wawatchi.gerakKanan2 = false;
                wawatchi.gerakKiriInfinite = false;
                wawatchi.gerakKananInfinite = false;
            }

            if (window.isKeyPressed(GLFW_KEY_M)){
                wawatchi.gerakKananInfinite = true;
                wawatchi.gerakKiriInfinite = false;
            }
            if(window.isKeyPressed(GLFW_KEY_N)){
                wawatchi.gerakKiriInfinite = true;
                wawatchi.gerakKananInfinite = false;
            }
        }

        // input atau gerakan khusus untuk tamatchi
        if (roleTamatchi && !roleWawatchi && !roleHikotchi){
            // Rotate
            if(window.isKeyPressed(GLFW_KEY_Q)) {
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            }

            if(window.isKeyPressed(GLFW_KEY_E)) {
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, -1.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            }

            if(window.isKeyPressed(GLFW_KEY_W)) {
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            }

            if(window.isKeyPressed(GLFW_KEY_S)) {
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            }

            if(window.isKeyPressed(GLFW_KEY_A)) {
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            }

            if(window.isKeyPressed(GLFW_KEY_D)) {
                Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
                tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
                tamatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
                tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            }

            // Translate
            if(window.isKeyPressed(GLFW_KEY_U)) {
                tamatchi.objectsSphere.get(0).translateObject(0.0f,0.0f,0.01f);
            }

            if(window.isKeyPressed(GLFW_KEY_O)) {
                tamatchi.objectsSphere.get(0).translateObject(0.0f,0.0f,-0.01f);
            }

            if(window.isKeyPressed(GLFW_KEY_I)) {
                tamatchi.objectsSphere.get(0).translateObject(0.0f, 0.005f, 0.0f);
            }

            if(window.isKeyPressed(GLFW_KEY_K)) {
                tamatchi.objectsSphere.get(0).translateObject(0.0f, -0.005f, 0.0f);
            }

            if(window.isKeyPressed(GLFW_KEY_J)) {
                tamatchi.objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
            }

            if(window.isKeyPressed(GLFW_KEY_L)) {
                tamatchi.objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
            }
            if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)){
                tamatchi.objectsSphere.get(6).rotateObject((float) Math.toRadians(tamatchi.limitKakiKiri), 1.0f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(7).rotateObject((float) Math.toRadians(tamatchi.limitKakiKanan), -1.0f, 0.0f, 0.0f);


                if (tamatchi.limitKakiKiri >= 0.5f) {
                    tamatchi.jarak *= -1;
                } else if (tamatchi.limitKakiKiri < -1f) {
                    tamatchi.jarak *= -1;
                }

                if (tamatchi.limitKakiKanan >= 0.5f) {
                    tamatchi.jarak *= -1;
                } else if (tamatchi.limitKakiKanan < -1f) {
                    tamatchi.jarak *= -1;
                }

                tamatchi.limitKakiKiri += tamatchi.jarak;
                tamatchi.limitKakiKanan += tamatchi.jarak;
                tamatchi.objectsSphere.get(6).rotateObject((float) Math.toRadians(tamatchi.limitKakiKiri), 1.0f, 0.0f, 0.0f);
                tamatchi.objectsSphere.get(7).rotateObject((float) Math.toRadians(tamatchi.limitKakiKanan), -1.0f, 0.0f, 0.0f);
            }
            if (window.isKeyPressed(GLFW_KEY_SPACE)) {
                tamatchi.goingUp = true;
            }

            if (tamatchi.goingUp) {
                tamatchi.limit += 0.0008f;
                System.out.println(tamatchi.limit);
            }

            if (tamatchi.limit >= 0.18f) {
                tamatchi.goingUp = false;
                tamatchi.goingDown = true;
            }

            if (tamatchi.goingDown) {
                tamatchi.limit -= 0.0008f;
                System.out.println(tamatchi.limit);
            }

            if (tamatchi.limit <= 0.0008f) {
                tamatchi.goingDown = false;
            }
        }

        // input atau gerakan khusus untuk hikotchi
        if (roleHikotchi && !roleWawatchi && !roleTamatchi){
            // Rotate
            if(window.isKeyPressed(GLFW_KEY_Q)) {
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_E)) {
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 0.0f, -1.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_W)) {
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_S)) {
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, -1.0f, 0.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_A)) {
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_D)) {
                Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
                for (int x = 0; x <= 9; x++) {
                    hikotchi.objectsSphere.get(x).translateObject(
                            -tempCenterPoint3.x,
                            -tempCenterPoint3.y,
                            -tempCenterPoint3.z
                    );
                    hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, -1.0f, 0.0f);
                    hikotchi.objectsSphere.get(x).translateObject(
                            tempCenterPoint3.x,
                            tempCenterPoint3.y,
                            tempCenterPoint3.z
                    );
                }
            }

            // Translate
            if(window.isKeyPressed(GLFW_KEY_U)) {
                for (Object object: hikotchi.objectsSphere){
                    object.translateObject(0.0f,0.0f,0.01f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_O)) {
                for (Object object: hikotchi.objectsSphere){
                    object.translateObject(0.0f,0.0f,-0.01f);
                }
            }

            if(window.isKeyPressed(GLFW_KEY_I)) {
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            0f,
                            0.005f,
                            0f
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_K)) {
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            0f,
                            -0.005f,
                            0f
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_J)) {
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            -0.01f,
                            0f,
                            0f
                    );
                }
            }

            if(window.isKeyPressed(GLFW_KEY_L)) {
                for (Sphere sphere : hikotchi.objectsSphere) {
                    sphere.translateObject(
                            0.005f,
                            0f,
                            0f
                    );
                }
            }
            if (window.isKeyPressed(GLFW_KEY_B)){
                hikotchi.attackNow();
                hikotchi.objectsAttack.get(0).translateObject(0.004f,0.0f,0.0f);
                hikotchi.objectsAttack.get(0).translateObject(0.0f,-0.004f,0.0f);
                hikotchi.objectsAttack.get(1).translateObject(0.007f,0.0f,0.0f);
                hikotchi.objectsAttack.get(1).translateObject(0.0f,-0.004f,0.0f);
                hikotchi.objectsAttack.get(2).translateObject(0.01f,0.0f,0.0f);
                hikotchi.objectsAttack.get(2).translateObject(0.0f,-0.004f,0.0f);
                hikotchi.objectsAttack.get(3).translateObject(0.013f,0.0f,0.0f);
                hikotchi.objectsAttack.get(3).translateObject(0.0f,-0.004f,0.0f);
            }
        }
    }


    public void loop() {
        while (window.isOpen()) {
            window.update();
            // ini untuk background colornya
            glClearColor(0.0f, 1.0f, 0.5f, 1.0f); // direset, tapi hanya 1 frame maka perlu diloop
            GL.createCapabilities();
            input();
            // code di bawah createcapabilities dan di atas restore state
            // pencet R muncul samaan semua
            if (gambarSekarang == 0){
                if (gantiGambar){
                    wawatchi.objectsSphere.clear();
                    wawatchi.objectTorus.clear();
                    wawatchi.objectsLuar.clear();
                    wawatchi.titikBezier.clear();
                    wawatchi.titikBezier2.clear();
                    wawatchi.init();
                    tamatchi.objectsSphere.clear();
                    tamatchi.titikBerzier.clear();
                    tamatchi.titikBerzier2.clear();
                    tamatchi.titikBerzier3.clear();
                    tamatchi.titikBerzier4.clear();
                    tamatchi.titikBerzier5.clear();
                    tamatchi.titikBerzier6.clear();
                    tamatchi.init();
                    hikotchi.objectsSphere.clear();
                    hikotchi.titikBerzier.clear();
                    hikotchi.titikBerzier1.clear();
                    hikotchi.titikBerzier2.clear();
                    hikotchi.titikBerzier3.clear();
                    hikotchi.titikBerzier4.clear();
                    hikotchi.init();
                    hikotchi.objectsAttack.clear();
                    bangunan1.objectsBangunan.clear();
                    bangunan1.init();
                    bangunan2.objectsBangunan.clear();
                    bangunan2.init();
                    bangunan3.objectsBangunan.clear();
                    bangunan3.init();
                    wawatchi.scaleObject(0.8f,0.8f,0.8f);
                    tamatchi.scaleObject(0.8f,0.8f,0.8f);
                    wawatchi.translateObject(0.3f,-0.2f,0.8f);
                    tamatchi.translateObject(1.0f, -0.43f, -0.1f);
                    bangunan1.translateObject(-0.5f,0.0f,-2.0f);
                    bangunan1.scaleObject(2.0f,2.0f,2.0f);
                    bangunan2.scaleObject(2.0f,2.0f,2.0f);
                    bangunan2.translateObject(0.0f,0.0f,-3.2f);
                    bangunan3.translateObject(0.8f,0.0f,-2.0f);
                    bangunan3.scaleObject(2.0f,2.0f,2.0f);
                    bangunan3.rotateObject(-20f,0.0f,1.0f,0.0f);
                    wawatchi.rotateObject(-7f, 0.0f, 1.0f, 0.0f);
                    tamatchi.rotateObject(-7f,0.0f,1.0f,0.0f);
                    hikotchi.rotateObject(40f,0.0f,1.0f,0.0f);
                    hikotchi.rotateObject(30f, 1.0f, 0.0f, 0.0f);
                    hikotchi.translateObject(-4.0f, 2.0f, -0.5f);
                    bangunan1.objectsBangunan.get(0).rotateObject(0.5f,0.0f,1.0f,0.0f);
                    gantiGambar = false;
                }
                wawatchi.loop();
                tamatchi.loop();
                hikotchi.loop();
                bangunan1.loop();
                bangunan2.loop();
                bangunan3.loop();
                // pencet T untuk muncul wawatchi saja
            } else if (gambarSekarang == 1){
                if (gantiGambar) {
                    wawatchi.objectsSphere.clear();
                    wawatchi.objectTorus.clear();
                    wawatchi.objectsLuar.clear();
                    wawatchi.titikBezier.clear();
                    wawatchi.titikBezier2.clear();
                    wawatchi.init();
                    gantiGambar = false;
                    roleWawatchi = true;
                    roleHikotchi = false;
                    roleTamatchi = false;
                }
                wawatchi.loop();
                // pencet F untuk muncul tamatchi saja
            } else if (gambarSekarang == 2){
                if (gantiGambar) {
                    tamatchi.objectsSphere.clear();
                    tamatchi.titikBerzier.clear();
                    tamatchi.titikBerzier2.clear();
                    tamatchi.titikBerzier3.clear();
                    tamatchi.titikBerzier4.clear();
                    tamatchi.titikBerzier5.clear();
                    tamatchi.titikBerzier6.clear();
                    tamatchi.init();
                    gantiGambar = false;
                }
                tamatchi.loop();
                // pencet G untuk muncul hikotchi saja
            } else if (gambarSekarang == 3){
                if (gantiGambar) {
                    hikotchi.objectsSphere.clear();
                    hikotchi.titikBerzier.clear();
                    hikotchi.titikBerzier1.clear();
                    hikotchi.titikBerzier2.clear();
                    hikotchi.titikBerzier3.clear();
                    hikotchi.titikBerzier4.clear();
                    hikotchi.objectsAttack.clear();
                    hikotchi.init();
                    gantiGambar = false;
                }
                hikotchi.loop();
            }

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
        new Main().run();
    }
}