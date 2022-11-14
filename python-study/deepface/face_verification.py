from deepface import DeepFace

verification = DeepFace.verify(img1_path = "images/m1.jpeg", img2_path = "images/1.jpeg")
print(verification)