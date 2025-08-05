import { useState, useEffect } from "react";
import "./App.css";

function App() {
  const [message, setMessage] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string>("");

  // .env.production에 VITE_API_BASE_URL=/api 로 설정
  const apiBaseUrl =
    import.meta.env.VITE_API_BASE_URL?.trim().replace(/\/$/, "") || "/api";

  const fetchHello = async () => {
    setLoading(true);
    setError("");
    try {
      const response = await fetch(`${apiBaseUrl}/hello`);
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.text();
      setMessage(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : "An error occurred");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchHello();
  }, []);

  return (
    <div className="app">
      <header className="app-header">
        <h1>Full Stack Test Project</h1>
        <p>React + Vite + Spring Boot</p>
      </header>

      <main className="app-main">
        <div className="api-section">
          <h2>API Test</h2>
          <div className="api-result">
            {loading && <p>Loading...</p>}
            {error && <p className="error">Error: {error}</p>}
            {message && <p className="success">Server Response: {message}</p>}
          </div>
          <button onClick={fetchHello} disabled={loading}>
            {loading ? "Loading..." : "Refresh API Call"}
          </button>
        </div>

        <div className="info-section">
          <h3>Project Information</h3>
          <ul>
            <li>
              <strong>Frontend:</strong> React 18 + Vite + TypeScript
            </li>
            <li>
              <strong>Backend:</strong> Spring Boot 3.x + Java 17
            </li>
            <li>
              <strong>API Base URL:</strong> {apiBaseUrl}
            </li>
            <li>
              <strong>Frontend Port:</strong> 80 (via Nginx)
            </li>
            <li>
              <strong>Backend Port:</strong> 8080 (Spring Boot)
            </li>
          </ul>
        </div>
      </main>
    </div>
  );
}

export default App;
