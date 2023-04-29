#version 330
uniform vec4 uni_color; // nyesuain sama yg di main ntar vec4 karena tipe data colornya vector 4
// out ngelempar variable yang ada di sini keluar
out vec4 frag_color;
// kalo in itu berharap masuk dari vert

void main(){
//    frag_color = vec4(1.0, 0.0, 0.0, 1.0);
    frag_color = uni_color;
}