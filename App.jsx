import React from 'react'
import Sidebar from './SideBar'
import Dashboard from './Dashboard'
import BookCatalog from './BookCatalog'

// Заглушки для компонентов
const UsersPage = () => (
    <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
        <h3 className="text-2xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent mb-4" style={{ background: 'linear-gradient(to right, #9333ea, #db2777)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent', backgroundClip: 'text' }}>
            Читатели
        </h3>
        <p className="text-pink-600" style={{ color: '#db2777' }}>Список читателей библиотеки</p>
    </div>
)

const ReportsPage = () => (
    <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
        <h3 className="text-2xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent mb-4" style={{ background: 'linear-gradient(to right, #9333ea, #db2777)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent', backgroundClip: 'text' }}>
            Отчеты
        </h3>
        <p className="text-pink-600" style={{ color: '#db2777' }}>Аналитика и отчеты</p>
    </div>
)

const SettingsPage = () => (
    <div className="bg-white/90 backdrop-blur-sm p-6 rounded-2xl shadow-2xl border-2 border-purple-200">
        <h3 className="text-2xl font-bold bg-gradient-to-r from-purple-600 to-pink-600 bg-clip-text text-transparent mb-4" style={{ background: 'linear-gradient(to right, #9333ea, #db2777)', WebkitBackgroundClip: 'text', WebkitTextFillColor: 'transparent', backgroundClip: 'text' }}>
            Настройки
        </h3>
        <p className="text-pink-600" style={{ color: '#db2777' }}>Настройки системы</p>
    </div>
)

// Структура навигации приложения
const navItems = [
    { name: 'Обзор', component: Dashboard },
    { name: 'Каталог Книг', component: BookCatalog },
    { name: 'Читатели', component: UsersPage },
    { name: 'Отчеты', component: ReportsPage },
    { name: 'Настройки', component: SettingsPage },
]

export default function App() {
    const [currentView, setCurrentView] = React.useState('Обзор')
    const CurrentComponent = navItems.find(item => item.name === currentView)?.component || Dashboard

    try {
        return (
            <div 
                className="flex min-h-screen font-sans" 
                style={{ 
                    minHeight: '100vh', 
                    width: '100%',
                    display: 'flex',
                    background: 'linear-gradient(135deg, #667eea 0%, #764ba2 25%, #f093fb 50%, #4facfe 75%, #00f2fe 100%)',
                    backgroundSize: '400% 400%',
                    animation: 'gradientShift 15s ease infinite'
                }}
            >
                <Sidebar navItems={navItems} currentView={currentView} setView={setCurrentView} />

                <main 
                    className="flex-1 p-8 overflow-y-auto" 
                    style={{ 
                        flex: 1, 
                        padding: '2rem',
                        overflowY: 'auto'
                    }}
                >
                    <header className="mb-8" style={{ marginBottom: '2rem' }}>
                        <h2 
                            className="text-4xl font-bold bg-gradient-to-r from-purple-600 via-pink-600 to-blue-600 bg-clip-text text-transparent drop-shadow-lg"
                            style={{
                                fontSize: '2.25rem',
                                fontWeight: '700',
                                background: 'linear-gradient(to right, #9333ea, #db2777)',
                                WebkitBackgroundClip: 'text',
                                WebkitTextFillColor: 'transparent',
                                backgroundClip: 'text'
                            }}
                        >
                            {currentView}
                        </h2>
                    </header>

                    <CurrentComponent />
                </main>
            </div>
        )
    } catch (error) {
        console.error('Error rendering App:', error)
        return (
            <div style={{ padding: '20px', color: 'red', background: 'white' }}>
                <h1>Ошибка загрузки приложения</h1>
                <p>{error.message}</p>
            </div>
        )
    }
}
