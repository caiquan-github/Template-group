#include "pch.h"
#include "com_caiquan_jni_JniDemo2.h"



extern "C" JNIEXPORT jint JNICALL Java_com_caiquan_jni_JniDemo2_compute
(JNIEnv* env, jclass jc , jint v1, jint v2) {
	return  v1+v2;
}