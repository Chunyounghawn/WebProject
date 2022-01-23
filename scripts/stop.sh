#!/usr/bin/env bash

ABSPATH=$(readlink -f $0) #stop.sh가 속해있는경로찾기
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh #자바로 치면 일종의 임포트 구문.이거때문에 profile.sh의 여러 펑션사용가능

IDLE_PORT=$(find_idle_port)

echo "> $IDLE_PORT 에서 구동중인 애플리케이션 pid 확인"
IDLE_PID=$(lsof -ti tcp:${IDLE_PORT})

if [ -z ${IDLE_PID} ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 ${IDLE_PID}
  sleep 5
fi