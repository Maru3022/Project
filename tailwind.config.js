module.exports = {
    content: [
        './index.html',
        './src/**/*.{js,jsx,ts,tsx}',
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
            },
        },
    },
    plugins: [],
}