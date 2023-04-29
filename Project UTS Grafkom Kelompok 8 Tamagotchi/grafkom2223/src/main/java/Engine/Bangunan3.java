package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

// Nathan Erens Anderson - c14210131
public class Bangunan3 {
    Camera camera;
    Projection projection;
    public boolean curve;
    public ArrayList<Object> titikBezier = new ArrayList<>();
    public ArrayList<Sphere> objectsBangunan = new ArrayList<>();

    public Bangunan3(Camera camera, Projection projection){
        this.camera = camera;
        this.projection = projection;
    }

    public void init(){
        //PARENT
        //kotak tengah
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.8f, 1.2f, .0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 3
        ));

        // speaker kanan atas
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1.0f, 0f, 0.0f, 1.0f),
                0f, 0f, 0f, 0.3f, 0.25f, 0.5f, 3
        ));
        objectsBangunan.get(1).translateObject(0.4f, 0.125f, 0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(1));


        // speaker kiri atas
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1.0f, 0f, 0.0f, 1.0f),
                0f, 0f, 0.0f, 0.3f, 0.25f, 0.5f, 3
        ));
        objectsBangunan.get(2).translateObject(-0.4f, 0.125f, 0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(2));

        //kanan bawah
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.5f, 3
        ));
        objectsBangunan.get(3).translateObject(0.38f, -0.125f, 0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(3));

        // kiri bawah
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.0f, 0f, 1.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.5f, 3
        ));
        objectsBangunan.get(4).translateObject(-0.38f, -0.125f, 0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(4));

        // speaker kanan atas
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.2f, 11
        ));
        objectsBangunan.get(5).scaleObject(0.3f, 0.3f, 0.3f);
        objectsBangunan.get(5).translateObject(0.39f, 0.125f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(5));

        // speaker kiri atas
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.2f, 11
        ));
        objectsBangunan.get(6).scaleObject(0.3f, 0.3f, 0.3f);
        objectsBangunan.get(6).translateObject(-0.39f, 0.125f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(6));

        //speaker kanan bawah
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.2f, 11
        ));
        objectsBangunan.get(7).scaleObject(0.3f, 0.3f, 0.3f);
        objectsBangunan.get(7).translateObject(0.37f, -0.125f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(7));

        //speaker kiri bawah
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.2f, 11
        ));
        objectsBangunan.get(8).scaleObject(0.3f, 0.3f, 0.3f);
        objectsBangunan.get(8).translateObject(-0.37f, -0.125f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(8));

        // gitar
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.6f, 0.29f, 0.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.2f, 11
        ));
        objectsBangunan.get(9).scaleObject(0.46f, 0.46f, 0.46f);
        objectsBangunan.get(9).translateObject(-0.1f, 0.325f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(9));

        // gitar
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.6f, 0.29f, 0.0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.2f, 11
        ));
        objectsBangunan.get(10).scaleObject(0.43f, 0.43f, 0.4f);
        objectsBangunan.get(10).translateObject(0f, 0.345f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(10));

        // gitar (lingkaran hitam)
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0f, 0f, 0f, 1.0f),
                0f, 0f, 0.0f, 0.25f, 0.25f, 0.05f, 11
        ));
        objectsBangunan.get(11).scaleObject(0.23f, 0.23f, 0.23f);
        objectsBangunan.get(11).translateObject(-0.05f, 0.325f, 0.335f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(11));

        // gitar
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1f, 1f, 1f, 1.0f),
                0f, 0f, 0.0f, 0.03f, 0.03f, 1f, 3
        ));
        objectsBangunan.get(12).scaleObject(0.4f, 0.4f, 0.4f);
        objectsBangunan.get(12).rotateObject((float) Math.toRadians(90), -0.22f, 1f, 0f);
        objectsBangunan.get(12).translateObject(0.02f, 0.37f, 0.345f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(12));

        // gitar
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(1f, 1f, 1f, 1.0f),
                0f, 0f, 0.0f, 0.03f, 0.03f, 1f, 3
        ));
        objectsBangunan.get(13).scaleObject(0.4f, 0.4f, 0.4f);
        objectsBangunan.get(13).rotateObject((float) Math.toRadians(90), -0.22f, 1f, 0f);
        objectsBangunan.get(13).translateObject(0.03f, 0.33f, 0.345f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(13));

        // gitar
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.6f, 0.29f, 0.0f, 1.0f),
                0f, 0f, 0.0f, 0.3f, 0.3f, 0.3f, 3
        ));
        objectsBangunan.get(14).scaleObject(0.4f, 0.4f, 0.4f);
        objectsBangunan.get(14).rotateObject((float) Math.toRadians(12),0f,0f,1f);
        objectsBangunan.get(14).translateObject(0.23f, 0.4f, 0.275f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(14));

        //pintu
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.6f, 0.29f, .0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.7f, 0.5f, 0.03f, 3
        ));
        objectsBangunan.get(15).scaleObject(0.4f, 0.4f, 0.4f);
        objectsBangunan.get(15).translateObject(0f, -0.145f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(15));

        //mata kiri
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.6f, 0.29f, .0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.7f, 0.2f, 0.03f, 0
        ));
        objectsBangunan.get(16).scaleObject(0.3f, 0.2f, 0.15f);
        objectsBangunan.get(16).rotateObject((float) Math.toRadians(-70),0f,0f,0.5f);
        objectsBangunan.get(16).translateObject(-0.1f, 0.1f, 0.255f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(16));

        //mata kanan
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0.6f, 0.29f, .0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.7f, 0.2f, 0.03f, 0
        ));
        objectsBangunan.get(17).scaleObject(0.3f, 0.2f, 0.15f);
        objectsBangunan.get(17).rotateObject((float) Math.toRadians(70),0f,0f,0.5f);
        objectsBangunan.get(17).translateObject(0.1f, 0.1f, 0.265f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(17));

        // pupil kanan
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0f, 0f, .0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.1f, 1
        ));
        objectsBangunan.get(18).scaleObject(0.04f, 0.04f, 0.04f);
        objectsBangunan.get(18).translateObject(0.1f, 0.1f, 0.265f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(18));

        // pupil kiri
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                // warna
        ), new Vector4f(0f, 0f, .0f, 1.0f),
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.1f, 1
        ));
        objectsBangunan.get(19).scaleObject(0.04f, 0.04f, 0.04f);
        objectsBangunan.get(19).translateObject(-0.1f, 0.1f, 0.265f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(19));


    }

    public void rotateObject(float degree, float x, float y, float z) {
        objectsBangunan.get(0).rotateObject((float)Math.toRadians(degree), x, y ,z);
    }


    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Sphere sphere : objectsBangunan) {
            sphere.scaleObject(scaleX, scaleY, scaleZ);
        }

    }

    public void translateObject(float x, float y, float z) {
        objectsBangunan.get(0).translateObject(x,y,z);
    }

    public void loop(){
        for (Sphere sphere: objectsBangunan){
            sphere.draw(camera, projection);
        }

    }
}
