@echo off
chcp 65001
cd C:\workspace\dobanjang\
git add -A
set /p commit_msg=커밋 메시지를 입력하세요: 
git commit -m "%commit_msg%"
git pull origin main
git push origin main&& (
echo 푸시 성공
) || (
  echo 푸시 실패
)
pause