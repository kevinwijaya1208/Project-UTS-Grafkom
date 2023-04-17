package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

// Torus = Kevin Wijaya / c14210124 (untuk donat yang mengelilingi karakter wawatchi)
public class Torus extends Elips{
    public float radiusz;
    public float centerz;
    List<Integer> index;
    int ibo;
    public Torus(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerx, float centery, float centerz, float radiusx, float radiusy, float radiusz) {
        super(shaderModuleDataList, vertices, color, centerx, centery, radiusx, radiusy);
        this.centerz = centerz;
        this.radiusz = radiusz;
        createTorus(radiusx, radiusy, 36,72);
        setupVAOVBO();
    }

    public void draw(){
        drawSetup();
        // Bind IBO dan draw
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_TRIANGLE_STRIP, index.size(), GL_UNSIGNED_INT, 0);
        // kalo mau lingkaran tanpa fill ganti ke GL_LINES
    }

    public void createTorus(float r1, float r2, int numSegments, int numSides) {
        vertices.clear();
        ArrayList<Integer> index = new ArrayList<>();

        float phi = 0, theta = 0;
        float dphi = (float) (2.0 * Math.PI / numSides);
        float dtheta = (float) (2.0 * Math.PI / numSegments / 2);

        for (int i = 0; i < numSides; i++) {
            phi = i * dphi;
            for (int j = 0; j < numSegments; j++) {
                theta = j * dtheta;

                Vector3f v = new Vector3f();
                v.x = (float) ((r1 + r2 * Math.cos(theta)) * Math.cos(phi));
                v.y = (float) ((r1 + r2 * Math.cos(theta)) * Math.sin(phi));
                v.z = (float) (r2 * Math.sin(theta));
                vertices.add(v);
            }
        }

        for (int i = 0; i < numSides; i++) {
            for (int j = 0; j < numSegments; j++) {
                int i1 = i * numSegments + j;
                int i2 = ((i + 1) % numSides) * numSegments + j;
                int i3 = i * numSegments + ((j + 1) % numSegments);
                int i4 = ((i + 1) % numSides) * numSegments + ((j + 1) % numSegments);
                index.add(i1);
                index.add(i3);
                index.add(i2);
                index.add(i2);
                index.add(i3);
                index.add(i4);
            }
        }
        this.index = index;
        setupIBO();
    }

    public void setupIBO() {
        // Create the index buffer object
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);

        // Get the indices as an int array
        int[] indices = new int[index.size()];
        for (int i = 0; i < index.size(); i++) {
            indices[i] = index.get(i);
        }

        // Send the indices to the IBO
        IntBuffer indicesBuffer = BufferUtils.createIntBuffer(indices.length);
        indicesBuffer.put(indices);
        indicesBuffer.flip();
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
    }
}

