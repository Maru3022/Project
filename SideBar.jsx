import React from 'react'
import { LayoutDashboard, Book, User, PieChart, Settings } from 'lucide-react'


export default function Sidebar({ navItems, currentView, setView }) {
    return (
        <div className="w-64 h-screen bg-white shadow-lg p-6 border-r border-gray-100 flex flex-col">
            <h1 className="text-3xl font-extrabold text-indigo-primary mb-10 tracking-wider">Libris Flow</h1>


            <nav className="flex-grow space-y-3">
                {navItems.map(item => {
                    const isActive = currentView === item.name
                    return (
                        <button
                            key={item.name}
                            onClick={() => setView(item.name)}
                            className={`flex items-center w-full p-3 rounded-xl transition-all duration-200 font-medium text-lg ${isActive ? 'bg-indigo-primary text-white shadow-md shadow-indigo-primary/40 transform scale-105' : 'text-gray-text hover:bg-indigo-50 hover:text-indigo-primary'}`}>
                            {/* Choose icon by name */}
                            <span className="w-6 h-6 mr-3 inline-flex items-center justify-center">
{item.name === 'Обзор' && <LayoutDashboard className="w-6 h-6" />}
                                {item.name === 'Каталог Книг' && <Book className="w-6 h-6" />}
                                {item.name === 'Читатели' && <User className="w-6 h-6" />}
                                {item.name === 'Отчеты' && <PieChart className="w-6 h-6" />}
                                {item.name === 'Настройки' && <Settings className="w-6 h-6" />}
</span>
                            {item.name}
                        </button>
                    )
                })}
            </nav>


            <div className="mt-8 pt-4 border-t border-gray-100 text-sm text-gray-400">© 2025 Libris Flow</div>
        </div>
    )
}