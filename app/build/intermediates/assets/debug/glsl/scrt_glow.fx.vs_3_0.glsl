uniform highp vec4 screenSize;
uniform highp vec4 EffectOffset;
attribute highp vec4 vPosition;
attribute highp vec2 vTexCoord0;
varying highp vec4 xlv_TEXCOORD0;
void main ()
{
  highp vec4 tmpvar_1;
  highp vec4 tmpvar_2;
  tmpvar_2.zw = vec2(0.0, 1.0);
  tmpvar_2.xy = (vPosition.xy + ((EffectOffset.xy * screenSize.zw) * 0.5));
  tmpvar_1.zw = vec2(0.0, 0.0);
  tmpvar_1.xy = vTexCoord0;
  gl_Position = tmpvar_2;
  xlv_TEXCOORD0 = tmpvar_1;
}

