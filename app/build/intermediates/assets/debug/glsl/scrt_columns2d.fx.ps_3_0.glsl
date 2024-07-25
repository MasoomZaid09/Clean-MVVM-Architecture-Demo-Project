precision mediump float;
uniform highp vec4 NeutralColor;
uniform highp vec4 BrushColor;
uniform highp vec4 PenColor;
uniform sampler2D BrushTexture;
varying highp vec4 xlv_COLOR0;
varying highp vec2 xlv_TEXCOORD0;
varying highp vec4 xlv_TEXCOORD1;
void main ()
{
  highp vec4 finalColor_1;
  finalColor_1 = xlv_COLOR0;
  if ((xlv_TEXCOORD1.x == -1.0)) {
    lowp vec4 tmpvar_2;
    tmpvar_2 = texture2D (BrushTexture, xlv_TEXCOORD0);
    highp vec4 tmpvar_3;
    tmpvar_3 = (BrushColor * tmpvar_2);
    highp vec4 tmpvar_4;
    tmpvar_4 = (xlv_COLOR0 - NeutralColor);
    highp float tmpvar_5;
    tmpvar_5 = dot (tmpvar_4, tmpvar_4);
    float tmpvar_6;
    if ((tmpvar_5 > 0.0)) {
      tmpvar_6 = 1.0;
    } else {
      tmpvar_6 = 0.0;
    };
    finalColor_1 = mix (tmpvar_3, xlv_COLOR0, vec4(tmpvar_6));
  } else {
    highp vec4 tmpvar_7;
    tmpvar_7 = (finalColor_1 - NeutralColor);
    highp float tmpvar_8;
    tmpvar_8 = dot (tmpvar_7, tmpvar_7);
    float tmpvar_9;
    if ((tmpvar_8 > 0.0)) {
      tmpvar_9 = 1.0;
    } else {
      tmpvar_9 = 0.0;
    };
    finalColor_1 = mix (PenColor, finalColor_1, vec4(tmpvar_9));
  };
  gl_FragData[0] = finalColor_1;
}

