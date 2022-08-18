import requests
import json

url = "http://127.0.0.1:10001/hello/test"

payload = json.dumps({
  "testValue": "test"
})
headers = {
  'Content-Type': 'application/json'
}

response = requests.request("GET", url, headers=headers, data=payload)

print(response.text)
