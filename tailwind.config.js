// tailwind.config.js
/** @type {import('tailwindcss').Config} */
module.exports = {
    // ЭТО ОЧЕНЬ ВАЖНО: Убедитесь, что Tailwind сканирует нужные файлы
    content: [
        "./index.html",
        "./*.{js,jsx,ts,tsx}", // Сканирование всех JSX/JS файлов в корне
    ],

    theme: {
        extend: {
            colors: {
                'indigo-primary': '#3F51B5',
                'indigo-light': '#5C6BC0',
                'coral-accent': '#FF7043',
                'gray-bg': '#F5F7FA',
                'gray-text': '#4B5563',
            },
            fontFamily: {
                sans: ['Inter', 'Arial', 'sans-serif'],
            }
        },
    },
    plugins: [],
}