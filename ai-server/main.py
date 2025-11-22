# ai-server/main.py
from fastapi import FastAPI, UploadFile, File
from pydantic import BaseModel
import os
from openai import OpenAI

# 환경변수에서 키 가져오기 (Docker가 주입해줌)
api_key = os.environ.get("OPENAI_API_KEY")
client = OpenAI(api_key=api_key)

app = FastAPI()

class TextRequest(BaseModel):
    text: str

@app.get("/")
def read_root():
    return {"message": "AI Server is running!"}

# 1. STT (녹음 -> 텍스트)
@app.post("/stt")
async def speech_to_text(file: UploadFile = File(...)):
    # 실제 오디오 파일을 받아서 처리하는 로직
    # (임시로 파일명만 반환)
    return {"filename": file.filename, "text": "변환된 텍스트입니다."}

# 2. 요약 기능
@app.post("/summary")
async def summarize_text(request: TextRequest):
    # GPT 호출 예시
    # response = client.chat.completions.create(...)
    return {"summary": f"'{request.text[:10]}...' 요약 완료"}