#include "pch.h"
#include "com_caiquan_jni_JniDemo.h"



extern "C" JNIEXPORT jstring JNICALL Java_com_caiquan_jni_JniDemo_getLine
(JNIEnv* env, jclass jc , jstring str) {
	return  str;
}