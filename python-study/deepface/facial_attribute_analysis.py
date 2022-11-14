from deepface import DeepFace

analysis = DeepFace.analyze(img_path="images/m1.jpeg", actions=["age", "gender", "emotion", "race"])
print(analysis)