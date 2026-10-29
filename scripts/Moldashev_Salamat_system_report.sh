#!/bin/bash
NAME="Moldashev Salamat"
LOG_FILE="$(cd "$(dirname "$0")" && pwd)/../logs/Moldashev_Salamat_system_report.log"
{
echo "=============================="
echo "Student: $NAME"
echo "Date/Time: $(date '+%Y-%m-%d %H:%M:%S')"
echo "User: $(whoami)"
echo "OS: $(. /etc/os-release && echo "$PRETTY_NAME")"
echo "Kernel: $(uname -r)"
echo "--- CPU ---"
lscpu | grep -E 'Model name|^CPU\(s\)'
echo "--- Memory ---"
free -h
echo "--- Disk usage ---"
df -h /
echo "--- Available disk space ---"
df -h --output=avail / | tail -1
echo
} | tee -a "$LOG_FILE"
