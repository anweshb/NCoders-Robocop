import pyrebase
import os

config = {
    "apiKey": "AIzaSyD3gio9Lc7t0IoDiKpr9DbYJyHpn37kkoE",
    "authDomain": "robocop-a9921.firebaseapp.com",
    "databaseURL": "https://robocop-a9921.firebaseio.com",
    "projectId": "robocop-a9921",
    "storageBucket": "robocop-a9921.appspot.com",
    "messagingSenderId": "974930343121",
    "appId": "1:974930343121:web:ac585d980803c9e72001f0"
  }

firebase = pyrebase.initialize_app(config)
storage = firebase.storage()

path_on_cloud = 'Images/'
path_local = "C://Users//Admin//Desktop//OpenCV-Face-Recognition//Detected//"

for img in os.listdir(path_local):
    storage.child(path_on_cloud+img).put(path_local+img)

print("Done")
