package Engine;

import org.joml.Matrix4f;

public class Projection {

    public float getFOV() {
        return FOV;
    }

    public void setFOV(float FOV) {
        this.FOV = FOV;
        updateProjMatrix(width, height);
    }

    private float FOV = (float) Math.toRadians(60.0f); // ini bisa diganti2 sendiri
    private static final float Z_FAR = 1000.f; // jarak terjauh dari kita ngeliat, kalo > 1000 ga keliatan
    private static final float Z_NEAR = 0.01f; // jarak terkecil, kalo < 0.01 ga bisa keliatan
    private int width, height;

    private Matrix4f projMatrix;

    public Projection(int width, int height) {
        projMatrix = new Matrix4f();
        updateProjMatrix(width, height);
    }

    public Matrix4f getProjMatrix() {
        return projMatrix;
    }

    public void updateProjMatrix(int width, int height) {
        this.width = width;
        this.height = height;
        // bisa .setPerspective atau .setOrtogonal
        projMatrix.setPerspective(FOV, (float) width / height, Z_NEAR, Z_FAR);
    }
}
