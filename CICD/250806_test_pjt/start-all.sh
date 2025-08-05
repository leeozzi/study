#!/bin/bash

echo "Starting Full Stack Project..."

# Start backend in background
echo "Starting backend..."
cd backend
./gradlew bootRun &
BACKEND_PID=$!

# Wait for backend to start
echo "Waiting for backend to start..."
sleep 10

# Start frontend
echo "Starting frontend..."
cd ../frontend
npm install
npm run dev &
FRONTEND_PID=$!

echo "Both services are starting..."
echo "Backend will be available at: http://localhost:8080"
echo "Frontend will be available at: http://localhost:5173"
echo ""
echo "Press Ctrl+C to stop all services"

# Wait for user to stop
wait 