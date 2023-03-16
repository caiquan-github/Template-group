from typing import Union
from fastapi import FastAPI

app = FastAPI()


# http://127.0.0.1:8000
@app.get("/")
async def root():
    return {"message": "Hello World"}


# http://127.0.0.1:8000/items/213?q=dwdw
@app.get("/items/{item_id}")
def read_item(item_id: int, q: Union[str, None] = None):
    return {"item_id": item_id, "q": q}
