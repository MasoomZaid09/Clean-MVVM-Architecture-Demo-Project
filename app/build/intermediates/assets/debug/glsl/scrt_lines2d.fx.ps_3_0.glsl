precision mediump float;
uniform highp vec4 PenThickness;
uniform sampler2D PenTexture;
varying highp vec4 xlv_COLOR0;
varying highp vec3 xlv_TEXCOORD0;
void main ()
{
  highp vec2 tmpvar_1;
  tmpvar_1.x = 0.5;
  tmpvar_1.y = xlv_TEXCOORD0.y;
  lowp vec4 tmpvar_2;
  tmpvar_2 = texture2D (PenTexture, tmpvar_1);
  highp vec4 fadedColor_3;
  fadedColor_3.xyz = xlv_COLOR0.xyz;
  fadedColor_3.w = 0.0;
  highp vec4 tmpvar_4;
  tmpvar_4 = (tmpvar_2 * mix (fadedColor_3, xlv_COLOR0, vec4(min (
    (min (xlv_TEXCOORD0.x, (1.0 - xlv_TEXCOORD0.x)) / (PenThickness.w / ((PenThickness.w * 2.0) + (PenThickness.x - PenThickness.w))))
  , 1.0))));
  gl_FragData[0] = tmpvar_4;
}

