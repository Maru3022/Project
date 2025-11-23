import './index.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';

// Рендеринг корневого компонента App
const rootElement = document.getElementById('root');
if (!rootElement) {
    console.error('Root element not found!');
} else {
    try {
        const root = ReactDOM.createRoot(rootElement);
        root.render(
            <React.StrictMode>
                <App />
            </React.StrictMode>
        );
    } catch (error) {
        console.error('Error rendering React app:', error);
        rootElement.innerHTML = `
            <div style="padding: 20px; color: red; background: white;">
                <h1>Ошибка загрузки приложения</h1>
                <p>${error.message}</p>
                <pre>${error.stack}</pre>
            </div>
        `;
    }
}