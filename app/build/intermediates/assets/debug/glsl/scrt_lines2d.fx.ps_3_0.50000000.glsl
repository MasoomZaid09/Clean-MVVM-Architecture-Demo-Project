precision mediump float;
uniform highp vec4 PenThickness;
uniform highp vec4 NanPenColor;
uniform sampler2D PenTexture;
uniform sampler2D NanPenTexture;
varying highp vec4 xlv_COLOR0;
varying highp vec3 xlv_TEXCOORD0;
void main ()
{
  highp vec4 tmpvar_1;
  highp vec2 tmpvar_2;
  tmpvar_2.x = 0.5;
  tmpvar_2.y = xlv_TEXCOORD0.y;
  lowp vec4 tmpvar_3;
  tmpvar_3 = texture2D (PenTexture, tmpvar_2);
  highp vec4 fadedColor_4;
  fadedColor_4.xyz = xlv_COLOR0.xyz;
  fadedColor_4.w = 0.0;
  highp vec4 tmpvar_5;
  tmpvar_5 = (tmpvar_3 * mix (fadedColor_4, xlv_COLOR0, vec4(min (
    (min (xlv_TEXCOORD0.x, (1.0 - xlv_TEXCOORD0.x)) / (PenThickness.w / ((PenThickness.w * 2.0) + (PenThickness.x - PenThickness.w))))
  , 1.0))));
  bool tmpvar_6;
  if ((xlv_TEXCOORD0.z < 0.0)) {
    highp float tmpvar_7;
    tmpvar_7 = abs(xlv_TEXCOORD0.y);
    tmpvar_6 = (tmpvar_7 < PenThickness.x);
  } else {
    tmpvar_6 = bool(0);
  };
  if (tmpvar_6) {
    tmpvar_1 = tmpvar_5;
  } else {
    lowp vec4 tmpvar_8;
    tmpvar_8 = texture2D (NanPenTexture, xlv_TEXCOORD0.xy);
    tmpvar_1 = mix (tmpvar_5, (NanPenColor * tmpvar_8), vec4(float((xlv_TEXCOORD0.y < 0.0))));
  };
  gl_FragData[0] = tmpvar_1;
}

