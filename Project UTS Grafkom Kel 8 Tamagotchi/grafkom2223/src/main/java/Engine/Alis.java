package Engine;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Alis extends Elips {
    public float torusRadius;
    public float tubeRadius;

    public float centerz;
    List<Integer> index;

    public Alis(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                float centerx, float centery, float centerz, float torusRadius, float tubeRadius) {
        super(shaderModuleDataList, vertices, color, centerx, centery, torusRadius, torusRadius);
        this.torusRadius = torusRadius;
        this.tubeRadius = tubeRadius;
        createTorus();
        setupVAOVBO();
    }

    private void createTorus() {
        vertices.clear();
        index = new ArrayList<>();

        int numc = 32; // number of sides for the tube
        int numt = 16; // number of segments for the torus

        float twopi = (float) (2 * Math.PI);
        float c = 0.0f;
        float t = 0.0f;
        float x, y, z;

        for (int i = 0; i < numt; i++) {
            for (int j = 0; j <= numc; j++) {
                for (int k = 1; k >= 0; k--) {
                    float s = (float) (i + k) % numt + 0.5f;
                    x = (float) ((torusRadius + tubeRadius * Math.cos(s * twopi / numt)) * Math.cos(c * twopi / numc));
                    y = (float) ((torusRadius + tubeRadius * Math.cos(s * twopi / numt)) * Math.sin(c * twopi / numc));
                    z = (float) (tubeRadius * Math.sin(s * twopi / numt));

                    vertices.add(new Vector3f(x, y, z));
                    index.add(vertices.size() - 1);
                }
                c += 1.0f / numc;
            }
            t += 1.0f / numt;
        }
    }
//        @Override
//    public void draw()
//    {
//        drawSetup();
//        glLineWidth(1);
//        glPointSize(5);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }

}

