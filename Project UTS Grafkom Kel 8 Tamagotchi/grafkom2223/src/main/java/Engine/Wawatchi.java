package Engine;

import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

// Class Wawatchi = Kevin Wijaya / c14210124
public class Wawatchi {
    public ArrayList<Object> titikBezier = new ArrayList<>();
    public ArrayList<Object> titikBezier2 = new ArrayList<>();
    public ArrayList<Sphere> objectsSphere = new ArrayList<>();
    public ArrayList<Torus> objectTorus = new ArrayList<>();
    public ArrayList<Sphere> objectsLuar = new ArrayList<>();

    private static float[][] controlPointsKiri = {
            {-0.1f, 0.016f, -0.22f},
            {-0.12f, 0.012f, -0.22f},
            {-0.146f, -0.002f, -0.22f},
            {-0.148f, -0.042f, -0.22f},
            {-0.14f, -0.058f, -0.22f},
            {-0.138f, -0.058f, -0.22f},
            {-0.094f, -0.12f, -0.22f},
            {0.002f, -0.048f, -0.22f},
            {-0.036f, 0.02f, -0.22f},
            {-0.088f, 0.026f, -0.22f},
            {-0.124f, 0.022f, -0.22f},
            {-0.124f, 0.002f, -0.22f},
            {-0.13f, -0.022f, -0.22f},
            {-0.124f, -0.052f, -0.22f},
            {-0.106f, -0.05f, -0.22f},
            {-0.09f, -0.046f, -0.22f},
            {-0.082f, -0.03f, -0.22f},
            {-0.088f, -0.016f, -0.22f},
            {-0.098f, -0.014f, -0.22f},
    };

    private static float[][] controlPointsKanan = {
            {0.11f, 0.016f, -0.22f},
            {0.09f, 0.012f, -0.22f},
            {0.064f, -0.002f, -0.22f},
            {0.062f, -0.042f, -0.22f},
            {0.07f, -0.058f, -0.22f},
            {0.072f, -0.058f, -0.22f},
            {0.116f, -0.12f, -0.22f},
            {0.212f, -0.048f, -0.22f},
            {0.174f, 0.02f, -0.22f},
            {0.122f, 0.026f, -0.22f},
            {0.086f, 0.022f, -0.22f},
            {0.086f, 0.002f, -0.22f},
            {0.08f, -0.022f, -0.22f},
            {0.086f, -0.052f, -0.22f},
            {0.104f, -0.05f, -0.22f},
            {0.12f, -0.046f, -0.22f},
            {0.128f, -0.03f, -0.22f},
            {0.122f, -0.016f, -0.22f},
            {0.112f, -0.014f, -0.22f},
    };
    int tes = 0;
    int tes2;

    public boolean isJumping;
    public boolean isFalling;
    public float y;

    public boolean toTheMoon;
    public float yToTheMoon;

    public int batasRotasi = 0;
    public boolean arahGerak = true;

    public boolean gerakKanan;
    public boolean gerakKiri;

    public boolean gerakKananInfinite;
    public boolean gerakKiriInfinite;
    public boolean gerakKanan2;

    public float timeGerakKanan = 0;
    public float timeGerakKiri = 0;

    public float timeGerakKanan2 = 0;


    public void init() {
        // spiral di pipi kiri
        titikBezier.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));

        // spiral di pipi kanan
        titikBezier2.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));

        // lingkaran donatnya (torus)
        objectTorus.add(new Torus(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.4f, 0.667f, 0.87f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.37f, 0.02f, 0.0f
        ));
        objectTorus.get(0).rotateObject((float) Math.toRadians(82), 1.0f, 0.04f, 0.0f);
        objectTorus.get(0).translateObject(0.0f, -0.15f, 0.f);

        // badan (tabung)
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 11
        ));
        objectsSphere.get(0).translateObject(0.0f, 0.0f, -0.15f);
        objectsSphere.get(0).rotateObject((float) Math.toRadians(90), 1.0f, 0.0f, 0.0f);

        // badan (elipsoid) atas
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 0
        ));
        objectsSphere.get(1).scaleObject(0.659f, 0.3f, 1.0f);
        objectsSphere.get(1).translateObject(0.0f, 0.15f, 0.0f);


        // badan (ellipsoid) bawah
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.8f, 0
        ));
        objectsSphere.get(2).scaleObject(0.659f, 0.3f, 1.0f);
        objectsSphere.get(2).translateObject(0.0f, -0.25f, 0.0f);

        // badan (ellipsoid) kiri
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.8f, 0
        ));
        objectsSphere.get(3).scaleObject(0.3f, 1.14f, 0.3f);
        objectsSphere.get(3).translateObject(-0.16f, -0.05f, 0.0f);

        // badan (ellipsoid) kanan
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.8f, 0
        ));
        objectsSphere.get(4).scaleObject(0.3f, 1.14f, 0.3f);
        objectsSphere.get(4).translateObject(0.16f, -0.05f, 0.0f);

        // muka ellipsoid
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.623f, 0.847f, 0.968f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(5).scaleObject(0.55f, 0.7f, 0.1f);
        objectsSphere.get(5).translateObject(0.0f, 0.0f, -0.2f);


        // mata kiri ellipsoid
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.298f, 0.521f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(6).scaleObject(0.07f, 0.13f, 0.1f);
        objectsSphere.get(6).translateObject(-0.05f, 0.035f, -0.21f);

        // mata kanan ellipsoid
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.298f, 0.521f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(7).scaleObject(0.07f, 0.13f, 0.1f);
        objectsSphere.get(7).translateObject(0.05f, 0.035f, -0.21f);

        // mulut border atas
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.015f, 0.294f, 0.525f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(8).scaleObject(0.14f, 0.1f, 0.1f);
        objectsSphere.get(8).translateObject(0.0f, -0.035f, -0.21f);

        // mulut border bawah
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.015f, 0.294f, 0.525f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(9).scaleObject(0.14f, 0.1f, 0.1f);
        objectsSphere.get(9).translateObject(0.0f, -0.065f, -0.21f);

        // mulut atas
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.949f, 0.670f, 0.792f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(10).scaleObject(0.13f, 0.06f, 0.15f);
        objectsSphere.get(10).translateObject(0.0f, -0.035f, -0.21f);

        // mulut bawah
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.949f, 0.670f, 0.792f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 0
        ));
        objectsSphere.get(11).scaleObject(0.13f, 0.06f, 0.15f);
        objectsSphere.get(11).translateObject(0.0f, -0.065f, -0.21f);

        // kaki kiri bawah elliptic paraboloid
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 7
        ));
        objectsSphere.get(12).scaleObject(0.16f, 0.08f, 0.2f);
        objectsSphere.get(12).rotateObject((float) Math.toRadians(170), 1.0f, -0.07f, 0.0f);
        objectsSphere.get(12).translateObject(-0.1f, -0.365f, 0.0f);

        // kaki kanan bawah elliptic paraboloid
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 7
        ));
        objectsSphere.get(13).scaleObject(0.16f, 0.08f, 0.2f);
        objectsSphere.get(13).rotateObject((float) Math.toRadians(170), 1.0f, 0.07f, 0.0f);
        objectsSphere.get(13).translateObject(0.1f, -0.365f, 0.0f);

        // tangan kiri elliptic paraboloid (badan bulet)
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 7
        ));
        objectsSphere.get(14).scaleObject(0.13f, 0.13f, 0.2f);
        objectsSphere.get(14).rotateObject((float) Math.toRadians(40), 0.0f, 0.0f, 1.0f);
        objectsSphere.get(14).translateObject(-0.29f, 0.0f, 0.0f);

        // tangan kanan elliptic paraboloid (badan bulet)
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 7
        ));
        objectsSphere.get(15).scaleObject(0.13f, 0.13f, 0.2f);
        objectsSphere.get(15).rotateObject((float) Math.toRadians(-50), 0.0f, 0.0f, 1.0f);
        objectsSphere.get(15).translateObject(0.31f, 0.0f, 0.0f);

        // topi atas elliptic paraboloid
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.827f, 0.929f, 0.988f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.4f, 7
        ));
        objectsSphere.get(16).scaleObject(0.1f, 0.1f, 0.2f);
        objectsSphere.get(16).rotateObject((float) Math.toRadians(-5), 0.0f, 0.0f, 1.0f);
        objectsSphere.get(16).translateObject(0.05f, 0.24f, 0.0f);

        // bola kuning di kepala
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0.952f, 0.247f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 1
        ));
        objectsSphere.get(17).scaleObject(0.05f, 0.05f, 0.05f);
        objectsSphere.get(17).translateObject(0.055f, 0.26f, 0.0f);


        // bola hijau di torus
        objectsLuar.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.415f, 0.741f, 0.513f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 1
        ));
        objectsLuar.get(0).scaleObject(0.06f, 0.06f, 0.08f);
        objectsLuar.get(0).translateObject(-0.12f, -0.215f, -0.35f);

        // bola oren di torus
        objectsLuar.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.929f, 0.431f, 0.278f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 1
        ));
        objectsLuar.get(1).scaleObject(0.08f, 0.08f, 0.08f);
        objectsLuar.get(1).translateObject(0.005f, -0.213f, -0.37f);

        // bola kuning di torus
        objectsLuar.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0.952f, 0.247f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.2f, 0.3f, 1
        ));
        objectsLuar.get(2).scaleObject(0.06f, 0.06f, 0.08f);
        objectsLuar.get(2).translateObject(0.13f, -0.205f, -0.35f);

        // childnya badan tabung itu badan atas(1) bawah(2) kiri(3) kanan(4), torus
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(1));
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(2));
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(3));
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(4));
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(5));
        objectsSphere.get(0).getChildObject().add(objectTorus.get(0));

        // child badan atas itu topi sm bola kuning
        objectsSphere.get(1).getChildObject().add(objectsSphere.get(16));
        objectsSphere.get(1).getChildObject().add(objectsSphere.get(17));

        // child badan kanan itu tangan kanan
        objectsSphere.get(4).getChildObject().add(objectsSphere.get(15));

        // child badan kiri itu tangan kiri
        objectsSphere.get(3).getChildObject().add(objectsSphere.get(14));

        // child badan bawah itu kaki kiri(12), kaki kanan(13)
        objectsSphere.get(2).getChildObject().add(objectsSphere.get(12));
        objectsSphere.get(2).getChildObject().add(objectsSphere.get(13));

        // childnya muka itu mata kiri(6), mata kanan(7), mulut border atas(8), mulut border atas(9), mulut atas(10), mulut bawah(11), bezier dan bezier2
        objectsSphere.get(5).getChildObject().add(objectsSphere.get(6));
        objectsSphere.get(5).getChildObject().add(objectsSphere.get(7));
        objectsSphere.get(5).getChildObject().add(objectsSphere.get(8));
        objectsSphere.get(5).getChildObject().add(objectsSphere.get(9));
        objectsSphere.get(5).getChildObject().add(objectsSphere.get(10));
        objectsSphere.get(5).getChildObject().add(objectsSphere.get(11));
        objectsSphere.get(5).getChildObject().add(titikBezier.get(0));
        objectsSphere.get(5).getChildObject().add(titikBezier2.get(0));

        // childnya torus 3 bola di luar (hijau(0), oren(1), kuning(2))s
        objectTorus.get(0).getChildObject().add(objectsLuar.get(0));
        objectTorus.get(0).getChildObject().add(objectsLuar.get(1));
        objectTorus.get(0).getChildObject().add(objectsLuar.get(2));

        // draw bezier curvenya
        bezier(controlPointsKiri, 1);
        bezier(controlPointsKanan, 2);
    }

    public void rotateObject(float degree, float x, float y, float z) {
        objectsSphere.get(0).rotateObject((float)Math.toRadians(degree), x, y ,z);
    }


    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Sphere sphere:  objectsSphere){
            sphere.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Torus torus: objectTorus){
            torus.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Sphere sphere:  objectsLuar){
            sphere.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object bezier:  titikBezier){
            bezier.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object bezier:  titikBezier2){
            bezier.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void translateObject(float x, float y, float z) {
        objectsSphere.get(0).translateObject(x,y,z);
    }

        public void bezier ( float[][] controlPoints, int pilihan){
            for (float t = 0; t <= 1; t += 0.01f) {
                float x = 0;
                float y = 0;
                float z = 0;
                int n = controlPoints.length - 1;
                for (int i = 0; i <= n; i++) {
                    int koefisien = koefSegitigaPascal(n, i);
                    float term = koefisien * (float) Math.pow(1 - t, n - i) * (float) Math.pow(t, i);
                    x += term * controlPoints[i][0];
                    y += term * controlPoints[i][1];
                    z += term * controlPoints[i][2];
                }
                if (tes == 0 && pilihan == 1) {
                    titikBezier.get(0).addVertices(new Vector3f(x, y, z));
                }
                if (tes2 == 0 && pilihan == 2) {
                    titikBezier2.get(0).addVertices(new Vector3f(x, y, z));
                }
            }
        }

        public int koefSegitigaPascal ( int n, int k){
            if (k < 0 || k > n) {
                return 0;
            }
            int koef = 1;
            for (int i = 0; i < k; i++) {
                koef *= (n - i);
                koef /= (i + 1);
            }
            return koef;
        }

        public void gerakTangan () {
            Vector3f temp1 = objectsSphere.get(11).updateCenterPoint();
            if (batasRotasi < 15 && arahGerak) {
                objectsSphere.get(14).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(14).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(14).translateObject(temp1.x, temp1.y, temp1.z);
                objectsSphere.get(15).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(15).rotateObject((float) Math.toRadians(0.2f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(15).translateObject(temp1.x, temp1.y, temp1.z);
                batasRotasi++;
            }
            if (batasRotasi > -15 && !arahGerak) {
                objectsSphere.get(14).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(14).rotateObject((float) Math.toRadians(-0.2f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(14).translateObject(temp1.x, temp1.y, temp1.z);
                objectsSphere.get(15).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(15).rotateObject((float) Math.toRadians(-0.2f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(15).translateObject(temp1.x, temp1.y, temp1.z);
                batasRotasi--;
            }
            // batasi checkRotate
            if (batasRotasi >= 15) {
                batasRotasi = 15;
                arahGerak = false;
            }
            if (batasRotasi <= -15) {
                batasRotasi = -15;
                arahGerak = true;
            }
        }

        public void gerakKaki () {
            Vector3f temp1 = objectsSphere.get(0).getChildObject().get(1).updateCenterPoint();
            if (batasRotasi < 40 && arahGerak) {
                objectsSphere.get(12).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(12).rotateObject((float) Math.toRadians(-1.2f), 1.0f, 0.0f, 0.0f);
                objectsSphere.get(12).translateObject(temp1.x, temp1.y, temp1.z);
                objectsSphere.get(13).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(13).rotateObject((float) Math.toRadians(1.2f), 1.0f, 0.0f, 0.0f);
                objectsSphere.get(13).translateObject(temp1.x, temp1.y, temp1.z);
                batasRotasi++;
            }
            if (batasRotasi > -40 && !arahGerak) {
                objectsSphere.get(12).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(12).rotateObject((float) Math.toRadians(1.2f), 1.0f, 0.0f, 0.0f);
                objectsSphere.get(12).translateObject(temp1.x, temp1.y, temp1.z);
                objectsSphere.get(13).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(13).rotateObject((float) Math.toRadians(-1.2f), 1.0f, 0.0f, 0.0f);
                objectsSphere.get(13).translateObject(temp1.x, temp1.y, temp1.z);
                batasRotasi--;
            }
            // batasi checkRotate
            if (batasRotasi >= 40) {
                batasRotasi = 40;
                arahGerak = false;
            }
            if (batasRotasi <= -40) {
                batasRotasi = -40;
                arahGerak = true;
            }
        }

        public void gerakKakiKananKiri () {
            Vector3f temp1 = objectsSphere.get(0).getChildObject().get(1).updateCenterPoint();
            if (batasRotasi < 15 && arahGerak) {
                objectsSphere.get(12).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(12).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(12).translateObject(temp1.x, temp1.y, temp1.z);
                objectsSphere.get(13).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(13).rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(13).translateObject(temp1.x, temp1.y, temp1.z);
                batasRotasi++;
            }
            if (batasRotasi > -15 && !arahGerak) {
                objectsSphere.get(12).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(12).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(12).translateObject(temp1.x, temp1.y, temp1.z);
                objectsSphere.get(13).translateObject(-temp1.x, -temp1.y, -temp1.z);
                objectsSphere.get(13).rotateObject((float) Math.toRadians(-0.5f), 0.0f, 0.0f, 1.0f);
                objectsSphere.get(13).translateObject(temp1.x, temp1.y, temp1.z);
                batasRotasi--;
            }
            // batasi checkRotate
            if (batasRotasi >= 15) {
                batasRotasi = 15;
                arahGerak = false;
            }
            if (batasRotasi <= -15) {
                batasRotasi = -15;
                arahGerak = true;
            }
        }

        public void gerakMaju () {
            gerakKakiKananKiri();
            for (Sphere sphere : objectsSphere) {
                sphere.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Torus torus : objectTorus) {
                torus.scaleObject(1.001f, 1.001f, 1.0f);
            }
            for (Sphere sphere : objectsLuar) {
                sphere.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Object bezier : titikBezier) {
                bezier.scaleObject(1.001f, 1.001f, 1.001f);
            }
            for (Object bezier : titikBezier2) {
                bezier.scaleObject(1.001f, 1.001f, 1.001f);
            }
        }




    public void loop() {

        // code di bawah createcapabilities dan di atas restore state
        for (Object object : objectsSphere) {
            object.draw();
        }
        for (Object object : objectTorus) {
            object.draw();
        }
        for (Object object : objectsLuar) {
            object.draw();
        }
        for (Object object : titikBezier) {
            object.drawLineBerzier();
        }
        for (Object object : titikBezier2) {
            object.drawLineBerzier();
        }
        if (isJumping) {
            objectsSphere.get(0).translateObject(0.0f, 0.0035f, 0.0f);
        }

        if (isFalling) {
            objectsSphere.get(0).translateObject(0.0f, -0.0045f, 0.0f);
        }

        if (toTheMoon) {
            for (Sphere sphere : objectsSphere) {
                sphere.scaleObject(0.997f, 0.997f, 0.999f);
            }
            for (Torus torus : objectTorus) {
                torus.scaleObject(0.997f, 0.997f, 1.0f);
            }
            for (Sphere sphere : objectsLuar) {
                sphere.scaleObject(0.997f, 0.997f, 0.999f);
            }
            for (Object bezier : titikBezier) {
                bezier.scaleObject(0.997f, 0.997f, 0.999f);
            }
            for (Object bezier : titikBezier2) {
                bezier.scaleObject(0.997f, 0.997f, 0.999f);
            }
            Vector3f tempCenterPoint1 = objectsSphere.get(11).updateCenterPoint();
            objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y, -tempCenterPoint1.z);
            objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 0.0f, 1.0f);
            objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y, tempCenterPoint1.z);
            objectsSphere.get(0).translateObject(0.0f, 0.004f, 0.0f);
            objectsSphere.get(0).translateObject(0.004f, 0.0f, 0.0f);
            gerakTangan();
        }

        if (gerakKanan || gerakKanan2 || gerakKananInfinite) {
            objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
            gerakTangan();
            gerakKakiKananKiri();
        }

        if (gerakKiri || gerakKiriInfinite) {
            objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
            gerakTangan();
            gerakKakiKananKiri();
        }


    }

}
