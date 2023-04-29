package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

// Kevin Wijaya - c14210124
public class Pohon {
    Camera camera;
    Projection projection;
    public boolean curve;
    public ArrayList<Object> titikBezier = new ArrayList<>();
    public ArrayList<Sphere> objectsPohon = new ArrayList<>();
    public ArrayList<Sphere> objectsBatang = new ArrayList<>();

    public Pohon(Camera camera, Projection projection){
        this.camera = camera;
        this.projection = projection;
    }

    public void init(){
        objectsPohon.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.2f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 13
        ));

        objectsPohon.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.2f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 13
        ));
        objectsPohon.get(1).translateObject(0.0f, 0.1f, 0.0f);

        objectsPohon.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.2f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 13
        ));
        objectsPohon.get(2).translateObject(0.0f, 0.2f, 0.0f);

        objectsPohon.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.2f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 13
        ));
        objectsPohon.get(3).translateObject(0.0f, 0.3f, 0.0f);

        objectsBatang.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.34f, 0.164f, 0.05f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.05f, 0.05f, 0.55f, 11
        ));
        objectsBatang.get(0).rotateObject((float)Math.toRadians(90), 1.0f,0.0f,0.0f);
        objectsBatang.get(0).translateObject(0.0f,-0.1f,0.0f);

        objectsBatang.get(0).getChildObject().add(objectsPohon.get(0));
        objectsBatang.get(0).getChildObject().add(objectsPohon.get(1));
        objectsBatang.get(0).getChildObject().add(objectsPohon.get(2));
        objectsBatang.get(0).getChildObject().add(objectsPohon.get(3));
    }

    public void rotateObject(float degree, float x, float y, float z) {
        objectsBatang.get(0).rotateObject((float)Math.toRadians(degree), x, y ,z);
    }


    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Sphere sphere : objectsPohon) {
            sphere.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Sphere batang : objectsBatang) {
            batang.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void translateObject(float x, float y, float z) {
        objectsBatang.get(0).translateObject(x,y,z);
    }

    public void loop(){
        for (Sphere sphere: objectsPohon){
            sphere.draw(camera, projection);
        }
        for (Sphere sphere:objectsBatang){
            sphere.draw(camera,projection);
        }
    }
}
