from deepface import DeepFace

# 默认模型 VGG-Face
verification = DeepFace.verify(img1_path="images/m1.jpeg", img2_path="images/m2.jpeg")
print(verification)

# 尝试使用  OpenFace模型
models = ["VGG-Face", "Facenet", "Facenet512", "OpenFace", "DeepFace", "DeepID", "ArcFace", "Dlib"]
verification1 = DeepFace.verify(img1_path="images/m1.jpeg", img2_path="images/m2.jpeg", model_name=models[3])
print(verification1)
