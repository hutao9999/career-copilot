#!/bin/bash

# MySQL service control script
# Usage: ./mysql.sh [start|stop]

if [ -z "$1" ]; then
    echo "Usage: $0 {start|stop}"
    echo "  start - Start MySQL service"
    echo "  stop  - Stop MySQL service"
    exit 1
fi

case "$1" in
    start)
        echo "Starting MySQL..."
        brew services start mysql
        ;;
    stop)
        echo "Stopping MySQL..."
        brew services stop mysql
        ;;
    *)
        echo "Invalid parameter: $1"
        echo "Usage: $0 {start|stop}"
        exit 1
        ;;
esac
